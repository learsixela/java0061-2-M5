package cl.biblioteca.digital.servlets.libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import cl.biblioteca.digital.models.Autor;
import cl.biblioteca.digital.models.Libro;
import cl.biblioteca.digital.servicios.AutorServicio;
import cl.biblioteca.digital.servicios.AutorServicioImpl;
import cl.biblioteca.digital.servicios.LibroServicio;
import cl.biblioteca.digital.servicios.LibroServicioImpl;

/**
 * Servlet implementation class ActualizarLibro
 */
@WebServlet("/libros/actualizar")
public class ActualizarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AutorServicio autorServicio = new AutorServicioImpl();
	private final LibroServicio libroServicio = new LibroServicioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id")); 
		Libro libro= libroServicio.obtenerLibro(id);
		request.setAttribute("libro", libro);
		
		// pasar a la vista
		List<Autor> listaAutores= autorServicio.obtenerTodosLosAutores();
		request.setAttribute("listaAutores", listaAutores);
		request.getRequestDispatcher("libro/editar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLibro = Integer.parseInt(request.getParameter("id"));
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int idAutor = Integer.parseInt(request.getParameter("autorId"));
		//validar si el autor existe
		Libro libro = new Libro();
		libro.setId(idLibro);
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAutor(new Autor(idAutor));
		
		libroServicio.actualizarLibro(libro);
		response.sendRedirect(request.getContextPath()+"/libros");
		
		
	}

}
