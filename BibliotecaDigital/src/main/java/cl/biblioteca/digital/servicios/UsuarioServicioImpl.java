package cl.biblioteca.digital.servicios;

import cl.biblioteca.digital.daos.UsuarioDAO;
import cl.biblioteca.digital.daos.UsuarioDAOImpl;
import cl.biblioteca.digital.dtos.UsuarioDTO;
import cl.biblioteca.digital.models.Usuario;
/**
 * Logica de negocio de la aplicacion
 */
public class UsuarioServicioImpl implements UsuarioServicio{
	private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	@Override
	public void guardarUsuario(UsuarioDTO usuario) {
		// validar, si el email existe o no
		
		usuarioDAO.guardarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuario(String email, String password) {
		// TODO Auto-generated method stub
		return usuarioDAO.obtenerUsuario(email, password);
	}

}
