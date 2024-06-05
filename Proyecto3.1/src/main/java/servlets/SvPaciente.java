package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import logica.Controladora;



/**
 *
 * @author Sergio
 */
@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {


    private final Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String responsable = request.getParameter("responsable");
        String nombre = request.getParameter("nombre");
        String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
        String especie = request.getParameter("especie");
        String raza = request.getParameter("raza");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatter.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        control.crearPaciente(responsable, nombre, fechaNacimiento, especie, raza);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
