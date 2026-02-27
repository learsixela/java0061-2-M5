package cl.biblioteca.digital.models;

public class Autor {

	private int id;
	private String nombre;
	public Autor(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Autor() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
