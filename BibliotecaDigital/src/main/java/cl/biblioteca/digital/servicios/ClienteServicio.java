package cl.biblioteca.digital.servicios;

import java.util.List;

import cl.biblioteca.digital.models.Cliente;

public interface ClienteServicio {

	List<Cliente> obtenerTodosLosClientes();

	Cliente obtenerCliente(int clienteId);

}
