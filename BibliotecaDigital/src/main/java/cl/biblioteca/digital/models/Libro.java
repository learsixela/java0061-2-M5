package cl.biblioteca.digital.models;

public class Libro {
	private int id;
	private String isbn;
	private String titulo;
	private Autor autor;
	public Libro() {
		super();
	}
	public Libro( String isbn, String titulo, Autor autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}
	public Libro(int id, String isbn, String titulo, Autor autor) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	

}
