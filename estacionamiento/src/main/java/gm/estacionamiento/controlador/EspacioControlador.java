package gm.estacionamiento.controlador;

import gm.estacionamiento.excepcion.RecursoNoEncontradoExcepcion;
import gm.estacionamiento.modelo.Espacio;
import gm.estacionamiento.servicio.EspacioServicio;
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
public class EspacioControlador {
    private static final Logger logger = LoggerFactory.getLogger(EspacioControlador.class);
    @Autowired
    private EspacioServicio espacioServicio;
    //http://localhost:8080/estacionamiento-app/espacios
    @GetMapping("/espacios")
    public List<Espacio> obtenerEspacios(){
        List<Espacio> espacios = this.espacioServicio.listarEspacios();
        logger.info("Espacios obtenidos: "+espacios);
        espacios.forEach((espacio -> logger.info(espacio.toString())));
        return espacios;
    }

    @PostMapping("/espacios")
    public Espacio agregarEspacio(@RequestBody Espacio espacio){
        logger.info("Espacio a agregar: "+espacio);
        return this.espacioServicio.guardarEspacio(espacio);
    }

    @GetMapping("/espacios/{id}")
    public ResponseEntity<Espacio> obtenerEspacioPorId(
            @PathVariable int id
    ){
        Espacio espacio = this.espacioServicio.buscarEspacioPorId(id);
        if (espacio!=null){
            return ResponseEntity.ok(espacio);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: "+id);
        }
    }

    @DeleteMapping("/espacios/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminarEspacio(
            @PathVariable int id
    ){
        Espacio espacio = espacioServicio.buscarEspacioPorId(id);

        if (espacio==null){
            throw new RecursoNoEncontradoExcepcion("No se econtró el id: "+id);
        }
        this.espacioServicio.eliminarEspacioPorId(espacio.getIdEspacio());

        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Espacio Eliminado", Boolean.TRUE);

        return ResponseEntity.ok(respuesta);
    }
}
