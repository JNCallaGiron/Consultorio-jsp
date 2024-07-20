
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;
import logica.Odontologo;
import logica.Usuario;

@WebServlet(name = "SvEditOdonto", urlPatterns = {"/SvEditOdonto"})
public class SvEditOdonto extends HttpServlet {
Controladora control = new Controladora ();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            
            //traigo al objeto odontologo
            
            Odontologo odonto = control.traerOdonto(id);
            
           
            
            HttpSession misession = request.getSession();
            misession.setAttribute("odoEditar", odonto);
            
            response.sendRedirect("editarOdonto.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traigo los valores del form-inputs
        String dni = request.getParameter("dni");
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String telefono=request.getParameter("telefono");
        String direccion= request.getParameter("direccion");
        String fechaStr=request.getParameter("fecha_nac");
        String especialidad= request.getParameter("especialidad");
        
        
        // Datos de usuario
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");

        // Datos de horario
        String horarioInicio = request.getParameter("horario_inicio");
        String horarioFin = request.getParameter("horario_fin");

        
       // Convierto la fecha_nac de String a Date usando el formato yyyy-MM-dd
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_naci = null;
        try {
            fecha_naci = format.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //obtengo el objeto odontologo de la sesion
         Odontologo odo = (Odontologo) request.getSession().getAttribute("odoEditar");
         
         odo.setDni(dni);
         odo.setNombre(nombre);
         odo.setApellido(apellido);
         odo.setTelefono(telefono);
         odo.setDireccion(direccion);
         odo.setFecha_nac(fecha_naci);
         odo.setEspecialidad(especialidad);
         
         
        //modifico los atributos del usuario relacionado con fk 
        Usuario usu = odo.getUnUsuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        odo.setUnUsuario(usu);
        
        
        Horario horario = odo.getUnHorario();
        horario.setHorario_inicio(horarioInicio);
        horario.setHorario_fin(horarioFin);
        odo.setUnHorario(horario);
        
        control.editarOdonto(odo);
       
        response.sendRedirect("verOdonto.jsp");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
