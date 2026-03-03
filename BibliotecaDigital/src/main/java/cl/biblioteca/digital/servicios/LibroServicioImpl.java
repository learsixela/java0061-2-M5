package cl.biblioteca.digital.servicios;

import cl.biblioteca.digital.daos.LibroDAO;
import cl.biblioteca.digital.daos.LibroDAOImpl;
import cl.biblioteca.digital.models.Libro;

public class LibroServicioImpl implements LibroServicio {

	private final LibroDAO libroDAO = new LibroDAOImpl();
	
	@Override
	public void crearLibro(Libro libro) {
		
		libroDAO.crearLibro(libro);
	}

}
