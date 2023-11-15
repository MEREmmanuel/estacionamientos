package gm.estacionamiento.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVehiculo;
    @Column(nullable = false)
    String marca;
    @Column(nullable = false)
    String modelo;
    @Column(nullable = false)
    String placa;
    @OneToOne
    @JoinColumn(nullable = false)
    Cliente Cliente;
}
