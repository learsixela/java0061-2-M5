package cl.biblioteca.digital.servlets.libro;

import java.io.IOException;
import java.util.List;

import cl.biblioteca.digital.daos.AutorDAO;
import cl.biblioteca.digital.daos.AutorDAOImpl;
import cl.biblioteca.digital.models.Autor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarLibro
 */
@WebServlet("/registrar/libro")
public class RegistrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtener los autores desde base datos
		AutorDAO autorDAO = new AutorDAOImpl();
		List<Autor> listaAutores= autorDAO.obtenerTodosLosAutores();
		// pasar a la vista
		request.setAttribute("listaAutores", listaAutores);
		
		// metodo encargado del despliegue del jsp
		request.getRequestDispatcher("libro/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//capturar parametros
		//validar los datos
		//envia al DAO
		//retornar mensaje(opcional)
		//vista de todos los libros
		
		
		
		
		
		
	}

}
