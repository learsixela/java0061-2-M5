package cl.biblioteca.digital.daos;

import java.sql.Connection;
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
                        rs.getString("nombre")
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
	public Autor obtenerTrabajador(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarAutor(Autor autor) {
		// TODO Auto-generated method stub
		
	}

}


