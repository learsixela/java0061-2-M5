package cl.biblioteca.digital.daos;

import cl.biblioteca.digital.dtos.UsuarioDTO;
import cl.biblioteca.digital.models.Usuario;

public interface UsuarioDAO {

	void guardarUsuario(UsuarioDTO usuario);

	Usuario obtenerUsuario(String email, String password);

}
