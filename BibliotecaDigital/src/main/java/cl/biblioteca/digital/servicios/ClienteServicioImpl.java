package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.daos.ClienteDAO;
import cl.biblioteca.digital.daos.ClienteDAOImpl;
import cl.biblioteca.digital.models.Cliente;

public class ClienteServicioImpl implements ClienteServicio {

	private final ClienteDAO clienteDAO = new ClienteDAOImpl();
	
	@Override
	public List<Cliente> obtenerTodosLosClientes() {
		
		return clienteDAO.obtenerTodosLosClientes();
	}

	@Override
	public Cliente obtenerCliente(int clienteId) {
		
		return clienteDAO.obtenerCliente(clienteId);
	}

}
