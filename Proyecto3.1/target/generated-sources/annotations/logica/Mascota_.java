package logica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Responsable;
import logica.Turno;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-20T20:57:36", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mascota.class)
public class Mascota_ extends Persona_ {

    public static volatile SingularAttribute<Mascota, String> especie;
    public static volatile SingularAttribute<Mascota, String> raza;
    public static volatile SingularAttribute<Mascota, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Mascota, Responsable> unResponsable;
    public static volatile ListAttribute<Mascota, Turno> listaTurnos;

}