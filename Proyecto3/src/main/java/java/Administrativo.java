
package java;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author Sergio
 */
@Entity
public class Administrativo extends Persona implements Serializable {
    @OneToOne
    private Usuario unUsuario;

    public Administrativo() {
    }

    public Administrativo(Usuario unUsuario, int id, String dni, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(id, dni, nombre, apellido, telefono, direccion, correo);
        this.unUsuario = unUsuario;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

   
    
    
}
