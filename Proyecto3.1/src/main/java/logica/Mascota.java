package logica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sergio
 */
@Entity
public class Mascota extends Persona implements Serializable{
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    private String raza;
    private String especie;  
    
    private String responsable;
    
    @OneToMany (mappedBy="pacien")
    private List<Turno>listaTurnos;
    
    
    public Mascota() {
    }

    public Mascota(String nombre, Date fecha_nacimiento, String raza, String especie, String responsable, List<Turno> listaTurnos, int id) {
        super(id);
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.raza = raza;
        this.especie = especie;
        this.responsable = responsable;
        this.listaTurnos = listaTurnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public void add(Mascota mascota) {
    }

    public void remove(Mascota mascota) {
    }











    
}
