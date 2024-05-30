package logica;

import java.util.ArrayList;
import java.util.Date;
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

    public Usuario traerUsuario(int id) {
        
        return controladoraPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controladoraPersis.editarUsuario(usu);
        
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        
        boolean ingreso=false;
        List<Usuario>listaUsuario=new ArrayList<Usuario>();
        listaUsuario=controladoraPersis.getUsuarios();
        
        for(Usuario usu: listaUsuario){
           if( usu.getNombreUsuario().equals(usuario)){
               if(usu.getContrasenia().equals(contrasenia)){
                   ingreso=true; //El usuario y contraseña son correctos
               }else{
                   ingreso=false;
               }
           }
        }
        return ingreso;
    }

    public void crearVet(String dni, String nombre, String apellido, String telefono, String correo, String direccion, String especialidad) {

        
                Veterinario vet=new Veterinario();
                vet.setDni(dni);
                vet.setNombre(nombre);
                vet.setApellido();
                vet.setTelefono(telefono);
                vet.setCorreo(correo);
                vet.setDireccion(direccion);
                vet.setEspecialidad(especialidad);


        controladoraPersis.crearVet(vet);
        
        //System.out.println("Controladora: Se comunica pasa los datos a controladora persistencia");
    }

public void crearPaciente(String responsable, String nombre, Date fechaNacimiento, String especie, String raza) {
    Mascota pac = new Mascota();
    pac.setResponsable(responsable);
    pac.setNombre(nombre);
    pac.setFecha_nacimiento(fechaNacimiento);
    pac.setEspecie(especie);
    pac.setRaza(raza);

    controladoraPersis.crearPac(pac);
}

    }

