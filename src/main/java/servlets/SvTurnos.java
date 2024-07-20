
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import logica.Paciente;
import logica.Turno;


@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {
 Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //no ocupar
    }

    
    //lleva los datos al  turnos.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Paciente paciente = control.traerPaciente(id);
        List<Odontologo> listaOdontologos = control.traerOdontologos();
        
        HttpSession session = request.getSession();
        session.setAttribute("paciente", paciente);
        session.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("turnos.jsp");
    }

    
    //crear el turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           // Obtengo los valores de los formularios
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        int idOdontologo = Integer.parseInt(request.getParameter("odontologo"));
        String fechaStr = request.getParameter("fecha_turno");
        String hora = request.getParameter("hora_turno");
        String afeccion = request.getParameter("afeccion");
        String obraSocial = request.getParameter("obra_social");
        // Convierto la fecha
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = format.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        //convierto el bolean de obra social
        boolean tiene_OS = obraSocial.equalsIgnoreCase("Si");

        // Asigno los valores a turno
        Turno turno = new Turno();
        turno.setFecha_turno(fecha);
        turno.setHora_turno(hora);
        turno.setAfeccion(afeccion);

        // Asigno el paciente y Odontologo
        Paciente paciente = control.traerPaciente(idPaciente);
        paciente.setTiene_OS(tiene_OS);
        
        Odontologo odonto = control.traerOdonto(idOdontologo);
        turno.setPacien(paciente);
        turno.setOdonto(odonto);
        

        // Creo el turno en la base de datos
        control.crearTurno(turno);

        response.sendRedirect("SvVerTurnos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
