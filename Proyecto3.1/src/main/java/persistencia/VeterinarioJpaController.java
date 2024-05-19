package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import logica.Veterinario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Sergio
 */
public class VeterinarioJpaController implements Serializable {

    public VeterinarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Veterinario veterinario) {
        if (veterinario.getListaTurnos() == null) {
            veterinario.setListaTurnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedListaTurnos = new ArrayList<Turno>();
            for (Turno listaTurnosTurnoToAttach : veterinario.getListaTurnos()) {
                listaTurnosTurnoToAttach = em.getReference(listaTurnosTurnoToAttach.getClass(), listaTurnosTurnoToAttach.getId_turno());
                attachedListaTurnos.add(listaTurnosTurnoToAttach);
            }
            veterinario.setListaTurnos(attachedListaTurnos);
            em.persist(veterinario);
            for (Turno listaTurnosTurno : veterinario.getListaTurnos()) {
                Veterinario oldVetOfListaTurnosTurno = listaTurnosTurno.getVet();
                listaTurnosTurno.setVet(veterinario);
                listaTurnosTurno = em.merge(listaTurnosTurno);
                if (oldVetOfListaTurnosTurno != null) {
                    oldVetOfListaTurnosTurno.getListaTurnos().remove(listaTurnosTurno);
                    oldVetOfListaTurnosTurno = em.merge(oldVetOfListaTurnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Veterinario veterinario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Veterinario persistentVeterinario = em.find(Veterinario.class, veterinario.getId());
            List<Turno> listaTurnosOld = persistentVeterinario.getListaTurnos();
            List<Turno> listaTurnosNew = veterinario.getListaTurnos();
            List<Turno> attachedListaTurnosNew = new ArrayList<Turno>();
            for (Turno listaTurnosNewTurnoToAttach : listaTurnosNew) {
                listaTurnosNewTurnoToAttach = em.getReference(listaTurnosNewTurnoToAttach.getClass(), listaTurnosNewTurnoToAttach.getId_turno());
                attachedListaTurnosNew.add(listaTurnosNewTurnoToAttach);
            }
            listaTurnosNew = attachedListaTurnosNew;
            veterinario.setListaTurnos(listaTurnosNew);
            veterinario = em.merge(veterinario);
            for (Turno listaTurnosOldTurno : listaTurnosOld) {
                if (!listaTurnosNew.contains(listaTurnosOldTurno)) {
                    listaTurnosOldTurno.setVet(null);
                    listaTurnosOldTurno = em.merge(listaTurnosOldTurno);
                }
            }
            for (Turno listaTurnosNewTurno : listaTurnosNew) {
                if (!listaTurnosOld.contains(listaTurnosNewTurno)) {
                    Veterinario oldVetOfListaTurnosNewTurno = listaTurnosNewTurno.getVet();
                    listaTurnosNewTurno.setVet(veterinario);
                    listaTurnosNewTurno = em.merge(listaTurnosNewTurno);
                    if (oldVetOfListaTurnosNewTurno != null && !oldVetOfListaTurnosNewTurno.equals(veterinario)) {
                        oldVetOfListaTurnosNewTurno.getListaTurnos().remove(listaTurnosNewTurno);
                        oldVetOfListaTurnosNewTurno = em.merge(oldVetOfListaTurnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = veterinario.getId();
                if (findVeterinario(id) == null) {
                    throw new NonexistentEntityException("The veterinario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Veterinario veterinario;
            try {
                veterinario = em.getReference(Veterinario.class, id);
                veterinario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The veterinario with id " + id + " no longer exists.", enfe);
            }
            List<Turno> listaTurnos = veterinario.getListaTurnos();
            for (Turno listaTurnosTurno : listaTurnos) {
                listaTurnosTurno.setVet(null);
                listaTurnosTurno = em.merge(listaTurnosTurno);
            }
            em.remove(veterinario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Veterinario> findVeterinarioEntities() {
        return findVeterinarioEntities(true, -1, -1);
    }

    public List<Veterinario> findVeterinarioEntities(int maxResults, int firstResult) {
        return findVeterinarioEntities(false, maxResults, firstResult);
    }

    private List<Veterinario> findVeterinarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Veterinario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Veterinario findVeterinario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Veterinario.class, id);
        } finally {
            em.close();
        }
    }

    public int getVeterinarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Veterinario> rt = cq.from(Veterinario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
