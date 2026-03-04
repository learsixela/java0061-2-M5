package cl.biblioteca.digital.servicios;

import cl.biblioteca.digital.dtos.UsuarioDTO;
import cl.biblioteca.digital.models.Usuario;

public interface UsuarioServicio {

	void guardarUsuario(UsuarioDTO usuario);

	Usuario obtenerUsuario(String email, String password);

}
