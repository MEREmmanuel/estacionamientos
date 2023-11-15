package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer idCliente);
    public Cliente guardarCliente(Cliente cliente);
    public void editarCliente(Cliente cliente, Cliente clienteRecibido);
    public void eliminarClientePorId(Integer idCliente);
}
