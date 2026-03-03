package cl.biblioteca.digital.servlets.libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.biblioteca.digital.models.Autor;
import cl.biblioteca.digital.models.Libro;
import cl.biblioteca.digital.servicios.AutorServicio;
import cl.biblioteca.digital.servicios.AutorServicioImpl;
import cl.biblioteca.digital.servicios.LibroServicio;
import cl.biblioteca.digital.servicios.LibroServicioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibroServlet
 */
@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AutorServicio autorServicio = new AutorServicioImpl();
	private final LibroServicio libroServicio = new LibroServicioImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtener datos desde la capa servivio(logica negocio)

		List<Autor> listaAutores= autorServicio.obtenerTodosLosAutores();
		// pasar a la vista
		request.setAttribute("listaAutores", listaAutores);
		
		// TODOS LOS LIBROS
		List<Libro> listaLibros= libroServicio.obtenerTodosLosLibros();
		// pasar a la vista
		request.setAttribute("listaLibros", listaLibros);
		
		request.getRequestDispatcher("libro/libro.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> msgErrores= new ArrayList<>();
 		
		//capturar los datos
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String autor_id = request.getParameter("autor");
		
		//validar los datos
		if(isbn == null || isbn.trim().isEmpty()
			||titulo == null || titulo.trim().isEmpty()
			||autor_id == null || autor_id.trim().isEmpty())  {
			msgErrores.add("Error en el ingreso de datos");
		}
		
		if(msgErrores.isEmpty()) {
			//convertir autor_id a numero Parse
			int id= Integer.parseInt(autor_id);
			//obtener el Autor desde bd
			Autor autor = autorServicio.obtenerAutor(id);
			if(autor!= null) {
				Libro libro = new Libro(isbn,titulo,autor);
				
				//enviar a capa servicios
				libroServicio.crearLibro(libro);
			} else {
				msgErrores.add("El autor seleccionado no existe");
			}
		}
		
		//redireccion a un jsp o servlet
		doGet(request, response);
		
	}

}
