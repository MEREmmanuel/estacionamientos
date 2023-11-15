package gm.estacionamiento.controlador;

import gm.estacionamiento.excepcion.RecursoNoEncontradoExcepcion;
import gm.estacionamiento.modelo.Registro;
import gm.estacionamiento.servicio.RegistroServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//http://localhost:8080/estacionamiento-app
@RequestMapping("estacionamiento-app")
@CrossOrigin(value = "http://localhost:4200")
public class RegistroControlador {
    private static final Logger logger = LoggerFactory.getLogger(RegistroControlador.class);
    @Autowired
    private RegistroServicio registroServicio;

    //http://localhost:8080/estacionamiento-app/registros
    @GetMapping("/registros")
    public List<Registro> obtenerRegistros(){
        List<Registro> registros = this.registroServicio.listarRegistros();
        logger.info("Clientes registros:"+registros);
        registros.forEach((registro -> logger.info(registros.toString())));
        return registros;
    }
}
