package gm.estacionamiento.controlador;

import gm.estacionamiento.enums.Estado;
import gm.estacionamiento.excepcion.RecursoNoEncontradoExcepcion;
import gm.estacionamiento.modelo.Espacio;
import gm.estacionamiento.modelo.Registro;
import gm.estacionamiento.modelo.Reserva;
import gm.estacionamiento.modelo.Vehiculo;
import gm.estacionamiento.servicio.EspacioServicio;
import gm.estacionamiento.servicio.RegistroServicio;
import gm.estacionamiento.servicio.ReservaServicio;
import gm.estacionamiento.servicio.VehiculoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/estacionamiento
@RequestMapping("/estacionamiento-app")
@CrossOrigin(value = "http://localhost:4200")
public class ReservaControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);
    @Autowired
    private ReservaServicio reservaServicio;
    @Autowired
    private EspacioServicio espacioServicio;
    @Autowired
    RegistroServicio registroServicio;
    @Autowired
    VehiculoServicio vehiculoServicio;



    //http://localhost:8080/estacionamiento-app/reservas
    @GetMapping("/reservas")
    public List<Reserva> obtenerReservas() {
        List<Reserva> reservas = this.reservaServicio.listarReservas();
        for (Reserva reserva : reservas){
            if (reserva.getFinFechaHora() != null && reserva.getFinFechaHora().isBefore(LocalDateTime.now())) {
                Espacio espacio = this.espacioServicio.buscarEspacioPorId(reserva.getEspacio().getIdEspacio());
                logger.info("Hora actual: "+Instant.now() + " Hora en la reserva "+reserva.getFinFechaHora());
                Vehiculo vehiculo = this.vehiculoServicio.buscarVehiculoPorCliente(reserva.getCliente().getIdCliente());
                Registro registro = new Registro(null, vehiculo, espacio, reserva.getInicioFechaHora(),reserva.getFinFechaHora());
                this.registroServicio.guardarRegistro(registro);
                this.reservaServicio.eliminarReservaPorId(reserva.getIdReserva());
                if (espacio != null && Estado.Reservado.equals(espacio.getEstado())) {
                    // Cambiar el estado del espacio a "reservado"
                    espacio.setEstado(Estado.Disponible);
                    // Actualizar el estado del espacio en la base de datos
                    espacioServicio.guardarEspacio(espacio);
                }
            }
        }
        logger.info("Reservas obtenidas: " + reservas);
        reservas.forEach(reserva -> logger.info(reserva.toString()));
        return reservas;
    }

    @PostMapping("/reservas")
    public Reserva guardarReserva(
            @RequestBody Reserva reserva
    ) {
        logger.info("Reserva a guardar : " + reserva);
        Espacio espacio = this.espacioServicio.buscarEspacioPorId(reserva.getEspacio().getIdEspacio());
        if (espacio != null && Estado.Disponible.equals(espacio.getEstado())) {
            // Cambiar el estado del espacio a "reservado"
            espacio.setEstado(Estado.Reservado);

            // Actualizar el estado del espacio en la base de datos
            espacioServicio.guardarEspacio(espacio);

            reserva.setInicioFechaHora(LocalDateTime.now());

            // Guardar la reserva en la base de datos
            return reservaServicio.guardarReserva(reserva);
        } else {
            throw new RecursoNoEncontradoExcepcion("El espacio no está disponible para reservar.");
        }
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(
            @PathVariable int id
    ) {
        Reserva reserva = this.reservaServicio.buscarReservaPorID(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> actualizarReservaPorId(
            @PathVariable int id,
            @RequestBody Reserva reservaRecibida
    ) {
        Reserva reserva = this.reservaServicio.buscarReservaPorID(id);
        if (reserva == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        reserva.setFinFechaHora(reservaRecibida.getFinFechaHora());

        this.reservaServicio.guardarReserva(reserva);

        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarReserva(
            @PathVariable int id
    ) {
        Reserva reserva = this.reservaServicio.buscarReservaPorID(id);
        if (reserva == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        this.reservaServicio.eliminarReservaPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Reserva Eliminada", Boolean.TRUE);
        Espacio espacio = this.espacioServicio.buscarEspacioPorId(reserva.getEspacio().getIdEspacio());
        if (espacio != null && Estado.Reservado.equals(espacio.getEstado())) {
            // Cambiar el estado del espacio a "reservado"
            espacio.setEstado(Estado.Disponible);

            // Actualizar el estado del espacio en la base de datos
            espacioServicio.guardarEspacio(espacio);
        } else {
            throw new RecursoNoEncontradoExcepcion("El espacio no estaba reservado.");
        }
        // Guardar la reserva en la base de datos
        return ResponseEntity.ok(respuesta);
    }
}
