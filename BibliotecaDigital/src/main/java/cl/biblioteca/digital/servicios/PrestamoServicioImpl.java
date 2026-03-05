package cl.biblioteca.digital.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cl.biblioteca.digital.daos.PrestamoDAO;
import cl.biblioteca.digital.daos.PrestamoDAOImpl;
import cl.biblioteca.digital.models.Prestamo;

public class PrestamoServicioImpl implements PrestamoServicio{
	private final PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
	
	
	private final int DIAS_PRESTAMO = 7;
	@Override
	public void solicitarPrestamo(Prestamo prestamo) {
		prestamo.setFecha_solicitud(LocalDateTime.now());
		prestamo.setFecha_vencimiento(LocalDate.now().plusDays(DIAS_PRESTAMO));
		
		prestamoDAO.solicitarPrestamo(prestamo);
	}

}
