package cl.biblioteca.digital.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cl.biblioteca.digital.models.Autor;
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

	@Override
	public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT l.id, l.isbn, l.titulo, a.id autor_id, a.nombre, a.nacionalidad \n"
            		+ "FROM libros l JOIN autores a ON a.id = l.autor_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Autor autor = new Autor(
                        rs.getInt("autor_id"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidad")
                );
            	
            	Libro libro = new Libro();
            	//setter
            	libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);
                //rs.getInt("autor_id")
            	
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
	}

	@Override
	public void eliminarLibro(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM libros WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Libro obtenerLibro(int id) {
       Libro libro = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT l.id, l.isbn, l.titulo, a.id autor_id, a.nombre, a.nacionalidad \n"
            		+ "FROM libros l JOIN autores a ON a.id = l.autor_id where l.id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	Autor autor = new Autor(
                        rs.getInt("autor_id"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidad")
                );
            	
            	libro = new Libro();
            	//setter
            	libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
	}

	@Override
	public void actualizarLibro(Libro libro) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE libros SET isbn = ?, titulo = ?, autor_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setDouble(3, libro.getAutor().getId());
            ps.setInt(4, libro.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
