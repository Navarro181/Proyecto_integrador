package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Mascota;
import logica.Veterinario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-20T20:57:36", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> Motivo_consulta;
    public static volatile SingularAttribute<Turno, Veterinario> vet;
    public static volatile SingularAttribute<Turno, Mascota> pacien;
    public static volatile SingularAttribute<Turno, String> Hora_turno;
    public static volatile SingularAttribute<Turno, String> fecha_turno;
    public static volatile SingularAttribute<Turno, Integer> id_turno;

}