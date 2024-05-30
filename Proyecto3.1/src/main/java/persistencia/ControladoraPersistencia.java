package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Mascota;
import logica.Usuario;
import logica.Veterinario;
import persistencia.exceptions.NonexistentEntityException;
/**
 *
 * @author Sergio
 */
public class ControladoraPersistencia {

        UsuarioJpaController usuJPA=new UsuarioJpaController();
        VeterinarioJpaController vetJPA=new VeterinarioJpaController();  
        MascotaJpaController pacJPA=new MascotaJpaController();
  
    public void crearUsuario(Usuario usuario){

        System.out.println("ControladoraPersistencia: Crea el usuario"); 

        usuJPA.create(usuario);
        System.out.println("ControladoraPersistencia: Se inserta el usuario en la BBDD");
    }


    public List<Usuario> getUsuarios() {
        return usuJPA.findUsuarioEntities();
    }
    
    public void borrarUsuario(int id){
            try {
                usuJPA.destroy(id);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Usuario traerUsuario(int id) {
            return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
            try {
                usuJPA.edit(usu);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void crearVet(Veterinario vet) {
        System.out.println("ControladoraPersistencia: Crea el veterinario"); 

        vetJPA.create(vet);
        System.out.println("ControladoraPersistencia: Se inserta el veterinario en la BBDD");    
    }
    
    public void crearPac (Mascota pac){
        pacJPA.create(pac);
    }
}
    