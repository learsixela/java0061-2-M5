package cl.hola.web.dao;

import java.sql.*;

import cl.hola.web.model.Usuario;
import cl.hola.web.util.BDConnectionMysql;
/**
 * logica para trabajar con base de datos
 */
public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public boolean registrar(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nick, email,password,edad,fecha_nacimiento) VALUES (?,?,?,?,?)";
		try(Connection conn = BDConnectionMysql.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, usuario.getNick());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setInt(4, usuario.getEdad());
			ps.setDate(5, Date.valueOf(usuario.getF_nacimiento()));
			
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error SQL: "+ e.toString()) ;
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public Usuario login(String email, String password) {
		String sql = "select id, nick, email,password,edad,fecha_nacimiento from usuarios"
				+ " where email = ? and password = ?";
		
		try(Connection conn = BDConnectionMysql.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			//while(rs.next()){}; cuando obtenemos una lista
			if(rs.next()) {
				Usuario usuario= new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNick(rs.getString("nick"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));//no es necesario
				usuario.setF_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
				usuario.setEdad(rs.getInt("edad"));
				
				return usuario;
			}
			
		} catch (SQLException e) {
			System.out.println("Error SQL: "+ e.toString()) ;
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
