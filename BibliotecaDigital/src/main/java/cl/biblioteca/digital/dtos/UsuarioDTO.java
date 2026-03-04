package cl.biblioteca.digital.dtos;

public class UsuarioDTO {
	private String nick= "";
	private String email= "";
	private String password= "";
	
	public UsuarioDTO(String nick, String email, String password) {
		super();
		this.nick = nick;
		this.email = email;
		this.password = password;
	}
	
	public UsuarioDTO() {
		super();
	}
	public String getNick() {
		return nick;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

}
