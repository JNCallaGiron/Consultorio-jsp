
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologo;


@WebServlet(name = "SvOdonto", urlPatterns = {"/SvOdonto"})
public class SvOdonto extends HttpServlet {
Controladora control = new Controladora ();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Odontologo> listaOdonto = new ArrayList<Odontologo>();
        
        //llamo al metodo para traer la lista de odontologos
        listaOdonto=control.getOdontos();
        
        HttpSession misession = request.getSession(); 
        misession.setAttribute("listaOdonto", listaOdonto);
        
       
        response.sendRedirect("verOdonto.jsp"); 
        
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
        
        
        control.crearOdonto(dni,nombre,apellido,telefono,direccion,fecha_naci,especialidad,
                nombreUsuario,contrasenia,rol,
                horarioInicio, horarioFin);
        
       
        response.sendRedirect("verOdonto.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
