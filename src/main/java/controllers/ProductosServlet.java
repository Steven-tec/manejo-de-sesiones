package controllers;
// Importación de clases necesarias para el funcionamiento del servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Producto;                    // Clase que representa el modelo Producto
import service.ProductoService;           // Interfaz del servicio de productos
import service.ProductoServiceImpl;       // Implementación concreta del servicio de productos

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// Anotación que indica que este servlet atenderá solicitudes hacia la URL "/productos"
@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

    // Método que se ejecuta cuando se hace una solicitud GET al servlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Crea una instancia del servicio que gestiona productos
        ProductoService service = new ProductoServiceImpl();

        // Obtiene la lista de productos llamando al método "listar"
        List<Producto> productos = service.listar();

        // Establece el tipo de contenido de la respuesta como HTML con codificación UTF-8
        resp.setContentType("text/html;charset=UTF-8");

        // Obtiene el flujo de salida para enviar la respuesta al cliente
        PrintWriter out = resp.getWriter();

        // Comienza a escribir la página HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Listar Producto</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listar producto</h1>");

        // Crea una tabla HTML con borde
        out.println("<table border='1'>");

        // Encabezados de la tabla
        out.println("<tr>");
        out.println("<th>ID PRODUCTO</th>");
        out.println("<th>NOMBRE</th>");
        out.println("<th>TIPO</th>");
        out.println("<th>PRECIO</th>");
        out.println("</tr>");

        // Itera sobre la lista de productos y muestra cada uno en una fila de la tabla
        for (Producto p : productos) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getNombre() + "</td>");
            out.println("<td>" + p.getTipo() + "</td>");
            out.println("<td>" + p.getPrecio() + "</td>");
            out.println("</tr>");
        }

        // Cierra la tabla y el resto de las etiquetas HTML
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}