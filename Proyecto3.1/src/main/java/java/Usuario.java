
package java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Sergio
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int id_usuasio;
    private String nombreUsuario;
    private String contrasenia;
    private String rol;

    public Usuario() {
    }

    public Usuario(int id_usuasio, String nombreUsuario, String contrasenia, String rol) {
        this.id_usuasio = id_usuasio;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public int getId_usuasio() {
        return id_usuasio;
    }

    public void setId_usuasio(int id_usuasio) {
        this.id_usuasio = id_usuasio;
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
