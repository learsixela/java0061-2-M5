package cl.biblioteca.digital.daos;

import java.util.List;

import cl.biblioteca.digital.models.Libro;

public interface LibroDAO {

	void crearLibro(Libro libro);

	List<Libro> obtenerTodosLosLibros();

	void eliminarLibro(int id);

	Libro obtenerLibro(int id);

	void actualizarLibro(Libro libro);

}
