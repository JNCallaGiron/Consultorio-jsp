
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

   Controladora control = new Controladora ();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //recibo las sesion: el usuario y contraseña del form de login jsp
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        
        //pregunto si el usuario y contraseña coinciden con la BD
        
        //siempre inicializo en false
        boolean validacion = false;
        
       // llamo a la controladora y le paso el usuario y contraseña
        validacion = control.comprobarIngreso(usuario,contrasenia);
        
        //creo el metodo para que la logica realice la validacion del usuario
        if (validacion == true) {
            
            //si es valido creo la sesion y le asigno el usuario a la sesion en cuestion 
            HttpSession misession = request.getSession(true);//getSession trae la sesion del usuario actual
            
            //seteo como atributo el usuario <- la sesion corresponde a este -> usuario
            misession.setAttribute("usuario",usuario);
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("loginError.jsp");
        }
        
        
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
