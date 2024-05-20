package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


/**
 *
 * @author Sergio
 */
public class Controladora {
    
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();
    
    /**
     *
     * @param nombreUsuario
     * @param rol
     * @param contrasenia
     */
    
    public void crearUsuario(String nombreUsuario,String rol, String contrasenia){
        
        Usuario usu=new Usuario();
        usu.setNombreUsuario(nombreUsuario);        
        usu.setRol(rol);
        usu.setContrasenia(contrasenia);
        System.out.println("Controladora: Setea los datos en Usuario");

        controladoraPersis.crearUsuario(usu);
        
        //System.out.println("Controladora: Se comunica pasa los datos a controladora persistencia");

    }
    public List<Usuario> getUsuarios(){
        
        return controladoraPersis.getUsuarios();
        
    }

    public void borrarUsuario(int id) {
        controladoraPersis.borrarUsuario(id);




    }

}
