package cl.biblioteca.digital.servlest.prestamo;

import java.io.IOException;
import java.util.List;

import cl.biblioteca.digital.enums.PrestamoEstado;
import cl.biblioteca.digital.models.Cliente;
import cl.biblioteca.digital.models.Libro;
import cl.biblioteca.digital.models.Prestamo;
import cl.biblioteca.digital.servicios.ClienteServicio;
import cl.biblioteca.digital.servicios.ClienteServicioImpl;
import cl.biblioteca.digital.servicios.LibroServicio;
import cl.biblioteca.digital.servicios.LibroServicioImpl;
import cl.biblioteca.digital.servicios.PrestamoServicio;
import cl.biblioteca.digital.servicios.PrestamoServicioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SolicitudPrestamo
 */
@WebServlet("/solicitud/prestamo")
public class SolicitudPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LibroServicio libroServicio = new LibroServicioImpl();
	private final ClienteServicio clienteServicio = new ClienteServicioImpl();
	private final PrestamoServicio prestamoServicio = new PrestamoServicioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//obtener los clientes
		List<Cliente> listaClientes = clienteServicio.obtenerTodosLosClientes();
		request.setAttribute("listaClientes", listaClientes);
		//obtener los libros
		List<Libro> listaLibros= libroServicio.obtenerTodosLosLibros();
		// pasar a la vista
		request.setAttribute("listaLibros", listaLibros);
		request.getRequestDispatcher("prestamo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("cliente"));
		int libroId = Integer.parseInt(request.getParameter("libro"));
		
		//capturar
		//validar ??
		//enviar a base datos
		Cliente cliente = clienteServicio.obtenerCliente(clienteId);
		Libro libro = libroServicio.obtenerLibro(libroId);
		
		Prestamo prestamo = new Prestamo();
		prestamo.setCliente(cliente);
		prestamo.setLibro(libro);
		//fechas, tratar en el servicio
		
		//estado
		prestamo.setEstado(PrestamoEstado.PRESTADO);
		
		prestamoServicio.solicitarPrestamo(prestamo);
		doGet(request, response);
	}

}
