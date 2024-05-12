package persistance;

import java.Usuario;

/**
 *
 * @author Sergio
 */
public class ControladoraPersistencia {
    HorarioJpaController horaJPA=new HorarioJpaController();
    VeterinarioJpaController vetJPA=new VeterinarioJpaController();
    MascotaJpaController mascJPA=new MascotaJpaController();
    PersonaJpaController personaJPA=new PersonaJpaController();
    ResponsableJpaController respJPA=new ResponsableJpaController();
    AdministrativoJpaController admJPA=new AdministrativoJpaController();
    TurnoJpaController tunoJPA=new TurnoJpaController();
    UsuarioJpaController usuJPA=new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }
}
