package cl.biblioteca.digital.models;

import java.time.LocalDate;

public class Usuario {
	//atributos
	private int id;
	private String nick; 
	private String email; 
	private String password;
	private int edad; 
	private LocalDate f_nacimiento;
	//constructores
	public Usuario() {
		super();
	}
	public Usuario(String nick, String email, String password, int edad, LocalDate f_nacimiento) {
		super();
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.edad = edad;
		this.f_nacimiento = f_nacimiento;
	}
	public Usuario(int id,String nick, String email, String password, int edad, LocalDate f_nacimiento) {
		super();
		this.id= id;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.edad = edad;
		this.f_nacimiento = f_nacimiento;
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getF_nacimiento() {
		return f_nacimiento;
	}
	public void setF_nacimiento(LocalDate f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", email=" + email + ", password=" + password + ", edad=" + edad
				+ ", f_nacimiento=" + f_nacimiento + "]";
	}
	
	

}
