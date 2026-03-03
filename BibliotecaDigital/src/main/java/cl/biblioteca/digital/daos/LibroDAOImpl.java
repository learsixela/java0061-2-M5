package cl.biblioteca.digital.daos;

import java.sql.*;

import cl.biblioteca.digital.models.Libro;
import cl.biblioteca.digital.util.DBConnection;

public class LibroDAOImpl implements LibroDAO{

	@Override
	public void crearLibro(Libro libro) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO libros (id, isbn, titulo, autor_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getIsbn());
            ps.setString(3, libro.getTitulo());
            //autor
            ps.setInt(4, libro.getAutor().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
