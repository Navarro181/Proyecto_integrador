package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;










/**
 *
 * @author Sergio
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
            
    Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario>listaUsuarios=new ArrayList<Usuario>();
        listaUsuarios=control.getUsuarios();
        
       // System.out.println("SvUsuarios: Recibimos la peticion de la controladora de los usuarios");
        
        HttpSession misession=request.getSession();
        misession.setAttribute("listaUsuarios", listaUsuarios);

        
       // System.out.println("Usuario "+ listaUsuarios.get(2));
        
        response.sendRedirect("verUsuarios.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                
        String nombreUsuario=request.getParameter("nombreusu");
        String rol=request.getParameter("rol");
        String contrasenia=request.getParameter("contrasenia");
        
        System.out.println("El nombre del usuario es: "+nombreUsuario);
  
       control.crearUsuario(nombreUsuario,rol,contrasenia);
  
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
