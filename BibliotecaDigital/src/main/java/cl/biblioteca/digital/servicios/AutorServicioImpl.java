package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.daos.AutorDAO;
import cl.biblioteca.digital.daos.AutorDAOImpl;
import cl.biblioteca.digital.models.Autor;

public class AutorServicioImpl implements AutorServicio {
	private final AutorDAO autorDAO = new AutorDAOImpl();

	@Override
	public List<Autor> obtenerTodosLosAutores() {
		//obtener los autores desde base datos
		
		return autorDAO.obtenerTodosLosAutores();
	}

	@Override
	public Autor obtenerAutor(int id) {
		//Autor autor = autorDAO.obtenerAutor(id);
		//return autor;
		return autorDAO.obtenerAutor(id);
	}

}
