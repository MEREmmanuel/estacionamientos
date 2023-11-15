package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Cliente;
import gm.estacionamiento.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public List<Cliente> listarClientes() {
        return this.clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        return this.clienteRepositorio.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return this.clienteRepositorio.save(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente, Cliente clienteRecibido) {
        cliente.setNombre(clienteRecibido.getNombre());
        cliente.setApellido(clienteRecibido.getApellido());
        cliente.setTelefono(clienteRecibido.getTelefono());
        cliente.setCorreoElectronico(clienteRecibido.getCorreoElectronico());
        this.guardarCliente(cliente);
    }

    @Override
    public void eliminarClientePorId(Integer idCliente) {
        this.clienteRepositorio.deleteById(idCliente);
    }
}
