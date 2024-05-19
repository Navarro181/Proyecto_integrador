package persistencia;

import java.util.ArrayList;
import java.util.List;
import logica.Usuario;

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
}
