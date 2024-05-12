package java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
@Entity
/**
 *
 * @author Sergio
 */
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_horario;
    private Time horario_inicio;
    private Time horario_fin;

    public Horario() {
    }

    public Horario(int id_horario, Time horario_inicio, Time horario_fin) {
        this.id_horario = id_horario;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(Time horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public Date getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(Time horario_fin) {
        this.horario_fin = horario_fin;
    }
    

}
