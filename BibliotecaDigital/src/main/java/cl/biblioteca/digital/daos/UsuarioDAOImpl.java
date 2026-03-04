package cl.biblioteca.digital.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.biblioteca.digital.dtos.UsuarioDTO;
import cl.biblioteca.digital.models.Usuario;
import cl.biblioteca.digital.util.DBConnection;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void guardarUsuario(UsuarioDTO usuario) {
		try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO usuarios (nick, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNick());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Usuario obtenerUsuario(String email, String password) {
		Usuario usuario = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, nick, email, password, edad, fecha_nacimiento, created_at\r\n"
            		+ " FROM biblioteca.usuarios where email= ? and password = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	usuario = new Usuario();
            	//setter
            	usuario.setId(rs.getInt("id"));
                usuario.setNick(rs.getString("nick"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
	}

}
