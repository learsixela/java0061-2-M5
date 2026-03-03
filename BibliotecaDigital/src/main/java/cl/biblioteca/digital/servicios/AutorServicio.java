package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.models.Autor;

public interface AutorServicio {

	List<Autor> obtenerTodosLosAutores();

	Autor obtenerAutor(int id);

}
