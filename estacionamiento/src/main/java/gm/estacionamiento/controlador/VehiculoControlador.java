package gm.estacionamiento.controlador;

import gm.estacionamiento.excepcion.RecursoNoEncontradoExcepcion;
import gm.estacionamiento.modelo.Vehiculo;
import gm.estacionamiento.servicio.VehiculoServicio;
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
public class VehiculoControlador {
    private static final Logger logger = LoggerFactory.getLogger(VehiculoControlador.class);
    @Autowired
    VehiculoServicio vehiculoServicio;

    //http://localhost:8080/estacionamiento-app/vehiculos

    @PostMapping("/vehiculos")
    public Vehiculo agregarVehiculo (@RequestBody Vehiculo vehiculo){
        logger.info("Agregar vehiculo: "+vehiculo);
        return this.vehiculoServicio.guardarVehiculo(vehiculo);
    }

    @GetMapping("/vehiculos/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorId(
            @PathVariable int id
    ){
        Vehiculo vehiculo = this.vehiculoServicio.buscarVehiculoPorId(id);
        if(vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el id -> "+id);
        }
    }

    @GetMapping("/vehiculosCliente/{idCliente}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorIdCliente(
            @PathVariable int idCliente
    ){
        Vehiculo vehiculo = this.vehiculoServicio.buscarVehiculoPorCliente(idCliente);
        if(vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el id -> "+idCliente);
        }
    }

    @PutMapping("/vehiculos/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(
            @PathVariable int id,
            @RequestBody Vehiculo vehiculoRecibido
    ){
        Vehiculo vehiculo = this.vehiculoServicio.buscarVehiculoPorId(id);
        if(vehiculo == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        vehiculo.setMarca(vehiculoRecibido.getMarca());
        vehiculo.setModelo(vehiculoRecibido.getModelo());
        vehiculo.setPlaca(vehiculoRecibido.getPlaca());
        this.vehiculoServicio.guardarVehiculo(vehiculo);

        return ResponseEntity.ok(vehiculo);
    }

    @DeleteMapping("/vehiculos/{id}")
    public ResponseEntity<Map<String,Boolean>> elimnarVehiculo(
            @PathVariable int id
    ){
        Vehiculo vehiculo = this.vehiculoServicio.buscarVehiculoPorId(id);

        if(vehiculo == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        this.vehiculoServicio.eliminarVehiculoPorId(vehiculo.getIdVehiculo());

        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Vehiculo Eliminado", Boolean.TRUE);

        return ResponseEntity.ok(respuesta);
    }
}
