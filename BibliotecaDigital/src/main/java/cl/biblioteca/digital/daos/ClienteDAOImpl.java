package cl.biblioteca.digital.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.biblioteca.digital.models.Cliente;
import cl.biblioteca.digital.util.DBConnection;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public List<Cliente> obtenerTodosLosClientes() {
		List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM clientes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nick"),
                        rs.getString("email")
                );
            	clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
	}

	@Override
	public Cliente obtenerCliente(int id) {
		Cliente cliente = null;
        try (Connection conn =  DBConnection.getConnection()) {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nick"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cliente;
	}

}
