package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import logica.Controladora;
import logica.Usuario;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {
    Controladora control=new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id=Integer.parseInt(request.getParameter("id"));
        Usuario usu=control.traerUsuario(id);
        HttpSession misession=request.getSession();
        misession.setAttribute("usuEditar", usu);
        
       //System.out.println("El usuario es: "+usu.getNombreUsuario());
        
        response.sendRedirect("editarUsuarios.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsu=request.getParameter("nombreusu");
        String rol=request.getParameter("rol");
        String contrasenia=request.getParameter("contrasenia");        
        
        Usuario usu=(Usuario)request.getSession().getAttribute("usuEditar");
        usu.setNombreUsuario(nombreUsu);
        usu.setRol(rol);
        usu.setContrasenia(contrasenia);
        
        control.editarUsuario(usu);
        
        response.sendRedirect("SvUsuarios");
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
