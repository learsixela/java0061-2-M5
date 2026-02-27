package cl.hola.web.dao;

import cl.hola.web.model.Usuario;

public interface UsuarioDAO {
	//CRUD
	//boolean registrar(String nick, String email, String password, int edad, Date f_nacimiento);
	boolean registrar(Usuario usuario);
	//boolean existeUsuario(int id);
	//Usuario buscarPorId(int id);
	Usuario login(String email, String password);
}
