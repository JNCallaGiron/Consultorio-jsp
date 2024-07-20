
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
import logica.Paciente;
import logica.Responsable;


@WebServlet(name = "SvEditPaciente", urlPatterns = {"/SvEditPaciente"})
public class SvEditPaciente extends HttpServlet {
Controladora control = new Controladora ();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Paciente pac = control.traerPaciente(id);
        
        HttpSession misession =request.getSession();
        misession.setAttribute("editPaciente", pac);
        
        response.sendRedirect("editarPaciente.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            // Traigo los valores del form-inputs
            String dni = request.getParameter("dni");
            String nombre= request.getParameter("nombre");
            String apellido= request.getParameter("apellido");
            String telefono=request.getParameter("telefono");
            String direccion= request.getParameter("direccion");
            String fechaStr=request.getParameter("fecha_nac");
            String obraSocial = request.getParameter("tiene_os");
            String tipoSangre = request.getParameter("tipoSangre");
            String unResponsable = request.getParameter("responsable");

            // Convierto la fecha_nac de String a Date usando el formato yyyy-MM-dd
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_naci = null;
            try {
                fecha_naci = format.parse(fechaStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Convierto obraSocial a booleano
            boolean tiene_OS = obraSocial.equalsIgnoreCase("Si");
            
            //traigo la sesion de paciente
            
           Paciente pac = (Paciente)request.getSession().getAttribute("editPaciente");
           pac.setDireccion(direccion);
           pac.setNombre(nombre);
           pac.setApellido(apellido);
           pac.setTelefono(telefono);
           pac.setDireccion(direccion);
           pac.setFecha_nac(fecha_naci);
           pac.setTiene_OS(tiene_OS);
           
           Responsable resp =pac.getUnResponsable();
           resp.setTipo_resp(unResponsable);
           
           pac.setUnResponsable(resp);
           
           control.editarPaciente(pac);
           
           response.sendRedirect("verPacientes.jsp");
     }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
