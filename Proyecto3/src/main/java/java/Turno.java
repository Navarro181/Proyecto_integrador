package java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sergio
 */
@Entity

public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_turno;
    @Temporal(TemporalType.DATE)
    private Date fecha_turno;
    @Temporal(TemporalType.TIME)
    private Time Hora_turno;
    private String Motivo_consulta;
    @ManyToOne
    @JoinColumn(name="vet")
    private Veterinario vet;
    
    @JoinColumn(name="pacien")
    private Mascota pacien;

    public Turno() {
    }

    public Turno(int id_turno, Date fecha_turno, Time Hora_turno, String Motivo_consulta, Veterinario vet, Mascota pacien) {
        this.id_turno = id_turno;
        this.fecha_turno = fecha_turno;
        this.Hora_turno = Hora_turno;
        this.Motivo_consulta = Motivo_consulta;
        this.vet = vet;
        this.pacien = pacien;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public Time getHora_turno() {
        return Hora_turno;
    }

    public void setHora_turno(Time Hora_turno) {
        this.Hora_turno = Hora_turno;
    }

    public String getMotivo_consulta() {
        return Motivo_consulta;
    }

    public void setMotivo_consulta(String Motivo_consulta) {
        this.Motivo_consulta = Motivo_consulta;
    }

    public Veterinario getVet() {
        return vet;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }

    public Mascota getPacien() {
        return pacien;
    }

    public void setPacien(Mascota pacien) {
        this.pacien = pacien;
    }


    

    


    
}
