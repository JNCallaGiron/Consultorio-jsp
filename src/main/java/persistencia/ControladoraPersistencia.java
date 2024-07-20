package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Responsable;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    HorarioJpaController horaJPA; // = new HorarioJpaController();
    OdontologoJpaController odontoJPA; //= new OdontologoJpaController();
    PacienteJpaController pacJPA; //= new PacienteJpaController();
    PersonaJpaController persJPA; //= new PersonaJpaController();
    ResponsableJpaController respJPA; //= new ResponsableJpaController();
    SecretarioJpaController secreJPA;// = new SecretarioJpaController();
    TurnoJpaController turnJPA; //= new TurnoJpaController();
    UsuarioJpaController usuJPA;// = new UsuarioJpaController();

    public ControladoraPersistencia() {
        
        usuJPA = new UsuarioJpaController();
        horaJPA = new HorarioJpaController();
        odontoJPA = new OdontologoJpaController();
        pacJPA= new PacienteJpaController();
        persJPA = new PersonaJpaController();
        respJPA = new ResponsableJpaController();
        secreJPA = new SecretarioJpaController();
        turnJPA = new TurnoJpaController();
    }

       
    public void crearUsuario(Usuario usu) {
            usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {
         return usuJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
            return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearOdonto(Odontologo odo) {
       try {
        // Guardar el usuario y horario antes de guardar el odontólogo
        usuJPA.create(odo.getUnUsuario());
        horaJPA.create(odo.getUnHorario());
        odontoJPA.create(odo);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public List<Odontologo> getOdontos() {
        return odontoJPA.findOdontologoEntities();
    }

    public void crearPaciente(Paciente paci) {
       
        pacJPA.create(paci);
    }
    

    public void crearResponsable(Responsable resp) {
        respJPA.create(resp);
    }

    public List<Paciente> traerPacientes() {
        return pacJPA.findPacienteEntities();
    }

    public void eliminarOdonto(int id) {
        try {
            odontoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPaciente(int id) {
        try {
            pacJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Odontologo traerOdonto(int id) {
        return odontoJPA.findOdontologo(id);
    }

    public void editarOdonto(Odontologo odo) {
        try {
            odontoJPA.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente traerPaciente(int id) {
        return pacJPA.findPaciente(id);
    }

    public void editarPaciente(Paciente pac) {
        try {
            pacJPA.edit(pac);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Odontologo> traerOdontologos() {
        return odontoJPA.findOdontologoEntities();
    }

    public void crearTurno(Turno turno) {
        turnJPA.create(turno);
    }

    public List<Turno> traerTurnos() {
        return turnJPA.findTurnoEntities();
    }

    public void eliminarTurno(int id) {
        try {
            turnJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
}
