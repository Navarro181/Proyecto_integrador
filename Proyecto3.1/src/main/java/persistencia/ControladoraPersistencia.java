package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


/**
 *
 * @author Sergio
 */
public class ControladoraPersistencia {

        UsuarioJpaController usuJPA=new UsuarioJpaController();

  
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
    
}
