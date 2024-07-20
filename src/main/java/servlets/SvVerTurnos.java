
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Turno;


@WebServlet(name = "SvVerTurnos", urlPatterns = {"/SvVerTurnos"})
public class SvVerTurnos extends HttpServlet {
Controladora control = new Controladora ();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de turnos
        List<Turno> listaTurnos = control.traerTurnos();
        
        // Guardar la lista en la sesión
        HttpSession session = request.getSession();
        session.setAttribute("listaTurnos", listaTurnos);
        
        // Redireccionar a verTurnos.jsp
        response.sendRedirect("verTurnos.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
