package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.LoginService;
import service.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //implementamos el objeto de tipo sesion
        LoginService auth = new LoginServiceImpl();
        //creaamos una variable opcional
        //para obtener el nombre del usuario
        Optional<String> usernameOptional= auth.getUsername(req);








        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                //Creo la plantilla html
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Hola " + usernameOptional.get() + " ya has iniciado sesion anteriormente</title>");
                out.println("<p><a href='" + req.getContextPath() + "/index.html'>Volver al inicio</a></p>");
                out.println("<p><a href='" + req.getContextPath() + "/logout'>Cerrar la sesion</a></p>");
                out.println("</body>");
                out.println("</html>");
                /*caso contrario me muedte un error * de me devulve al login */
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if(USERNAME.equals("username") && PASSWORD.equals("password")) {
                //no poner la siguiente linea de codigo antes de usar el metodo get

                //creo la sesion
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                resp.sendRedirect(req.getContextPath() + "/index.html");
            } else  {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Lo sentimos no esta autorizado para ingresar a esta pagina");

            }
    }
}
