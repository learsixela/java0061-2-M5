package cl.biblioteca.digital.daos;

import java.sql.*;
import cl.biblioteca.digital.models.Prestamo;
import cl.biblioteca.digital.util.DBConnection;

public class PrestamoDAOImpl implements PrestamoDAO{

	@Override
	public void solicitarPrestamo(Prestamo prestamo) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO prestamos (cliente_id, libro_id,fecha_solicitud,fecha_vencimiento, estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prestamo.getCliente().getId());
            ps.setInt(2, prestamo.getLibro().getId());
            //casteo 
            ps.setTimestamp(3, Timestamp.valueOf(prestamo.getFecha_solicitud()));
            ps.setDate(4, Date.valueOf(prestamo.getFecha_vencimiento()));
            ps.setString(5, prestamo.getEstado().name());//emun
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
