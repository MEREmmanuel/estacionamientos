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
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRegistro;
    @ManyToOne
    @JoinColumn(nullable = false)
    Vehiculo Vehiculo;
    @ManyToOne
    @JoinColumn(nullable = false)
    Espacio Espacio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    LocalDateTime entradaFechaHora;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    LocalDateTime salidaFechaHora;
}
