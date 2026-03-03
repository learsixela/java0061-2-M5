package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.models.Libro;

public interface LibroServicio {

	void crearLibro(Libro libro);

	List<Libro> obtenerTodosLosLibros();

	void eliminarLibro(int id);

	Libro obtenerLibro(int id);

	void actualizarLibro(Libro libro);

	
}
