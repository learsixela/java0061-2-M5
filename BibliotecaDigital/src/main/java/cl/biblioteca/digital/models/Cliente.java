package cl.biblioteca.digital.models;

public class Cliente {
	private int id;
	private String nick; 
	private String email;
	public Cliente() {
		super();
	}
	public Cliente(String nick, String email) {
		super();
		this.nick = nick;
		this.email = email;
	}
	public Cliente(int id, String nick, String email) {
		super();
		this.id = id;
		this.nick = nick;
		this.email = email;
	}
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
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nick=" + nick + ", email=" + email + "]";
	} 
	
}
