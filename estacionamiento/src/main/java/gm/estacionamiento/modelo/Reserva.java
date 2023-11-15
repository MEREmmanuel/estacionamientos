package gm.estacionamiento.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idReserva;
    @ManyToOne
    @JoinColumn(nullable = false)
    Cliente cliente;
    @ManyToOne
    @JoinColumn(nullable = false)
    Espacio espacio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    LocalDateTime inicioFechaHora;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    LocalDateTime finFechaHora;
}
