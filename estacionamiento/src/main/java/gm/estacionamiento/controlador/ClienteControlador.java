package gm.estacionamiento.controlador;

import gm.estacionamiento.excepcion.RecursoNoEncontradoExcepcion;
import gm.estacionamiento.modelo.Cliente;
import gm.estacionamiento.servicio.ClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/estacionamiento
@RequestMapping("estacionamiento-app")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);
    @Autowired
    private ClienteServicio clienteServicio;

    //http://localhost:8080/estacionamiento-app/clientes
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = this.clienteServicio.listarClientes();
        logger.info("Clientes obtenidos:"+clientes);
        clientes.forEach((cliente -> logger.info(cliente.toString())));
        return clientes;
    }

    @PostMapping("/clientes")
    public Cliente agregarCliente(@RequestBody Cliente cliente){
        logger.info("Cliente a agregar:"+cliente);
        return this.clienteServicio.guardarCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(
            @PathVariable int id
    ){
        Cliente cliente = this.clienteServicio.buscarClientePorId(id);
        if(cliente != null) {
            return ResponseEntity.ok(cliente);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el id -> "+id);
        }
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable int id,
            @RequestBody Cliente clienteRecibido
    ){
        Cliente cliente = this.clienteServicio.buscarClientePorId(id);
        if(cliente == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        this.clienteServicio.editarCliente(cliente,clienteRecibido);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String,Boolean>> elimnarCliente(
            @PathVariable int id
    ){
        Cliente cliente = this.clienteServicio.buscarClientePorId(id);

        if(cliente == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        this.clienteServicio.eliminarClientePorId(cliente.getIdCliente());

        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Cliente Eliminado", Boolean.TRUE);

        return ResponseEntity.ok(respuesta);
    }
}
