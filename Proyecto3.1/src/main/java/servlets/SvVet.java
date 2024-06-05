package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Controladora;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "SvVet", urlPatterns = {"/SvVet"})
public class SvVet extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* 
        List<Usuario>listaVeterinarios=new ArrayList<Usuario>();
        listaVeterinarios=control.getUsuarios();
        
       // System.out.println("SvUsuarios: Recibimos la peticion de la controladora de los usuarios");
        
        HttpSession misession=request.getSession();
        misession.setAttribute("listaVeterinarios", listaVeterinarios);

        
       // System.out.println("Usuario "+ listaUsuarios.get(2));
        
        response.sendRedirect("verVet.jsp");
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");

        // System.out.println("El nombre del usuario es: "+nombreUsuario);
        control.crearVet(dni, nombre, apellido, telefono, correo, direccion, especialidad);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
