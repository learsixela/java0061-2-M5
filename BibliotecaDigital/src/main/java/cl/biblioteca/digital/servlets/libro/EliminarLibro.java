package cl.biblioteca.digital.servlets.libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import cl.biblioteca.digital.servicios.LibroServicio;
import cl.biblioteca.digital.servicios.LibroServicioImpl;


@WebServlet("/libros/eliminar")
public class EliminarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LibroServicio libroServicio = new LibroServicioImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id")); 
		libroServicio.eliminarLibro(id);
		response.sendRedirect(request.getContextPath()+"/libros");
		//request.getRequestDispatcher("libro/libro.jsp").forward(request, response);
	}

}
