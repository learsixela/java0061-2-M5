package cl.biblioteca.digital.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cl.biblioteca.digital.enums.PrestamoEstado;

public class Prestamo {
	private int id;
	//private int cliente_id;
	//private int libro_id;
	private Cliente cliente;
	private Libro libro;
	private LocalDateTime fecha_solicitud;
	private LocalDateTime fecha_devolucion;
	private LocalDate fecha_vencimiento;
	
	private PrestamoEstado estado;
//G&S
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public LocalDateTime getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(LocalDateTime fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public LocalDateTime getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(LocalDateTime fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public LocalDate getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public PrestamoEstado getEstado() {
		return estado;
	}

	public void setEstado(PrestamoEstado estado) {
		this.estado = estado;
	}
	
	
	
	
	

}
