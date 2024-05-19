
package logica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 *
 * @author Sergio
 */
@Entity
public class Veterinario extends Persona{
    private String especialidad;
    @OneToMany(mappedBy="vet")
    private List<Turno>listaTurnos;
    @OneToOne
    private Usuario unUsuario;
    @OneToOne
    private Horario unHorario;

    public Veterinario() {
    }

    public Veterinario(String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario, int id, String dni, String nombre, String apellido, String telefono, String direccion, String correo) {
        super(id, dni, nombre, apellido, telefono, direccion, correo);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }


    
}
