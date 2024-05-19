
package logica;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Entity;



/**
 *
 * @author Sergio
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int id_usuario;
    private String nombreUsuario;
    private String rol;
    private String contrasenia;


    public Usuario() {
    }

    public Usuario(int id_usuasio, String nombreUsuario,String rol,String contrasenia) {
        this.id_usuario = id_usuasio;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.contrasenia = contrasenia;
    }
    
    

    public int getId_usuasio() {
        return id_usuario;
    }

    public void setId_usuasio(int id_usuasio) {
        this.id_usuario = id_usuasio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
            
    
}
