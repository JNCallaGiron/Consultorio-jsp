package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    public void crearUsuario (String nombreUsuario, String contrasenia, String rol) {
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
        controlPersis.crearUsuario(usu);
    
    }

    public List <Usuario> getUsuarios() {
       
        return controlPersis.getUsuarios();
        
        
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        
        return controlPersis.traerUsuario(id);
     }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
    
    //del servel login
    public boolean comprobarIngreso(String usuario, String contrasenia) {
        

        //declaro el ingreso como falso
        boolean ingreso = false;
        
        //traigo la lista de usuarios y la almaceno en una array list
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        //el objeto lista usuario  guarda la lista de usuario traida de la persistencia
        
        listaUsuarios = controlPersis.getUsuarios();//creo el metodo en la logica
        
        //recorro la lista para saber si lista de la BD coincide con el usuario  que trae el SERVLET
        for (Usuario usu : listaUsuarios) {
            if(usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    ingreso = true; 
                }
                else {
                    ingreso = false;//deniega el acceso si los datos no coinciden
                }
            
            }
        }
       return ingreso; 
    }
    
    
    //metodo para dar de alta al odontologo
    public void crearOdonto(String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_naci, 
            String especialidad,
            String nombreUsuario, String contrasenia, String rol,
            String horarioInicio, String horarioFin) {
        Odontologo odo = new Odontologo();
        odo.setDni(dni);
        odo.setNombre(nombre);
        odo.setApellido(apellido);
        odo.setTelefono(telefono);
        odo.setDireccion(direccion);
        odo.setFecha_nac(fecha_naci);
        odo.setEspecialidad(especialidad);
        
        
      
        //creo el objeto para usuario     
        Usuario usuario = new Usuario ();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);
        odo.setUnUsuario(usuario);
        
        //creo el objeto para horarios
        Horario horario = new Horario();
        horario.setHorario_inicio(horarioInicio);
        horario.setHorario_fin(horarioFin);
        odo.setUnHorario(horario);
        
        controlPersis.crearOdonto(odo);
    }

    public List<Odontologo> getOdontos() {
        return controlPersis.getOdontos();
    }

    public void crearPaciente(String dni, String nombre, String apellido, String telefono,
            String direccion, Date fecha_naci, boolean tiene_OS, String tipoSangre, String unResponsable) {
        Paciente paci = new Paciente ();
    
    paci.setDni(dni);
    paci.setNombre(nombre);
    paci.setApellido(apellido);
    paci.setTelefono(telefono);
    paci.setDireccion(direccion);
    paci.setFecha_nac(fecha_naci);
    paci.setTiene_OS(tiene_OS);
    paci.setTipoSangre(tipoSangre);

    Responsable resp = new Responsable();
    resp.setTipo_resp(unResponsable);

    controlPersis.crearResponsable(resp); // Persistir el Responsable primero
    paci.setUnResponsable(resp);

    controlPersis.crearPaciente(paci); // Luego persistir el Paciente

    }

    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();
    }

    public void eliminarOdonto(int id) {
        controlPersis.eliminarOdonto(id);
    }

    public void eliminarPaciente(int id) {
        controlPersis.eliminarPaciente(id);
    }

    public Odontologo traerOdonto(int id) {
        return controlPersis.traerOdonto(id);
    }

    public void editarOdonto(Odontologo odo) {
        controlPersis.editarOdonto(odo);
    }
    
    //para el metodo edit
    public Paciente traerPaciente(int id) {
        return controlPersis.traerPaciente(id);
    }

    public void editarPaciente(Paciente pac) {
        controlPersis.editarPaciente(pac);
    }

    public List<Odontologo> traerOdontologos() {
        return controlPersis.traerOdontologos();
    }

    public void crearTurno(Turno turno) {
        controlPersis.crearTurno(turno);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public void eliminarTurno(int id) {
        controlPersis.eliminarTurno(id);
    }

    

   
  

    
    
    
}
