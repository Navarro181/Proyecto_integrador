package java;

import persistance.ControladoraPersistencia;

/**
 *
 * @author Sergio
 */
public class Controladora {
    ControladoraPersistencia controlPersis= new ControladoraPersistencia();
    
    public void crearUsuario(int id, String nombreUsuario, String contrasenia, String rol){
        Usuario usu=new Usuario(id,nombreUsuario,contrasenia,rol);
        controlPersis.crearUsuario(usu);
    }
    
}
