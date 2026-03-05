package cl.biblioteca.digital.daos;

import java.util.List;

import cl.biblioteca.digital.models.Cliente;

public interface ClienteDAO {

	List<Cliente> obtenerTodosLosClientes();

	Cliente obtenerCliente(int clienteId);

}
