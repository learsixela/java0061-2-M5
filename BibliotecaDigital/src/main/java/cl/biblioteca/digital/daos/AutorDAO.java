package cl.biblioteca.digital.daos;

import java.util.List;

import cl.biblioteca.digital.models.Autor;

public interface AutorDAO {
    void agregarAutor(Autor autor);
    Autor obtenerAutor(int id);
    List<Autor> obtenerTodosLosAutores();
    void actualizarAutor(Autor autor);
}


