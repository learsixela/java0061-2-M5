package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.daos.LibroDAO;
import cl.biblioteca.digital.daos.LibroDAOImpl;
import cl.biblioteca.digital.models.Libro;

public class LibroServicioImpl implements LibroServicio {

	private final LibroDAO libroDAO = new LibroDAOImpl();
	
	@Override
	public void crearLibro(Libro libro) {
		libroDAO.crearLibro(libro);
	}

	@Override
	public List<Libro> obtenerTodosLosLibros() {
		return libroDAO.obtenerTodosLosLibros();
	}

	@Override
	public void eliminarLibro(int id) {
		libroDAO.eliminarLibro(id);
		
	}

	@Override
	public Libro obtenerLibro(int id) {
		
		return libroDAO.obtenerLibro(id);
	}

	@Override
	public void actualizarLibro(Libro libro) {
		libroDAO.actualizarLibro(libro);
		
	}

}
