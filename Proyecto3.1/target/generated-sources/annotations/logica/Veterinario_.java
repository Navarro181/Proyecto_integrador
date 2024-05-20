package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Horario;
import logica.Turno;
import logica.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-20T20:57:36", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Veterinario.class)
public class Veterinario_ extends Persona_ {

    public static volatile SingularAttribute<Veterinario, Usuario> unUsuario;
    public static volatile SingularAttribute<Veterinario, String> especialidad;
    public static volatile ListAttribute<Veterinario, Turno> listaTurnos;
    public static volatile SingularAttribute<Veterinario, Horario> unHorario;

}