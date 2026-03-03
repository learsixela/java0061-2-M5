package cl.biblioteca.digital.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.biblioteca.digital.models.Autor;
import cl.biblioteca.digital.util.DBConnection;

public class AutorDAOImpl implements AutorDAO {

    @Override
    public List<Autor> obtenerTodosLosAutores() {
        List<Autor> autores = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM autores";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Autor autor = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidad")
                );
                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }

	@Override
	public void agregarAutor(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Autor obtenerAutor(int id) {
		Autor autor = null;
        try (Connection conn =  DBConnection.getConnection()) {
            String sql = "SELECT * FROM autores WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	autor = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("nacionalidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return autor;
	}

	@Override
	public void actualizarAutor(Autor autor) {
		// TODO Auto-generated method stub
		
	}

}


