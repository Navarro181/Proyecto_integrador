package persistencia;

import logica.Usuario;

/**
 *
 * @author Sergio
 */
public class ControladoraPersistencia {

    
    public void crearUsuario(Usuario usuario){
        //System.out.println("ControladoraPersistencia: Crea el usuario");
        UsuarioJpaController usuJPA=new UsuarioJpaController();
       // System.out.println("ControladoraPersistencia: Se inserta el usuario en la BBDD");
        usuJPA.create(usuario);
    }
}
