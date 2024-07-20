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
import logica.Paciente;

@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // traer a los pacientes por lista
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        // método para traer a los pacientes
        listaPacientes = control.traerPacientes();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaPacientes", listaPacientes);

        response.sendRedirect("verPacientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Traigo los valores del form-inputs
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fechaStr = request.getParameter("fecha_nac");
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

        // Llamo al método de la controladora para crear el paciente
        control.crearPaciente(dni, nombre, apellido, telefono, direccion, fecha_naci, tiene_OS, tipoSangre, unResponsable);

        response.sendRedirect("verPacientes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
