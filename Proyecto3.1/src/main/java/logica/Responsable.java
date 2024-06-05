
package logica;

import javax.persistence.Entity;

/**
 *
 * @author Sergio
 */
@Entity
public class Responsable extends Persona{
       public Responsable() {
        
    }

    public Responsable(int id, String dni, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(id, dni, nombre, apellido, telefono, direccion, correo);
    }


    

    
}
