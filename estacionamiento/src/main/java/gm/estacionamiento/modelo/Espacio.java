package gm.estacionamiento.modelo;

import gm.estacionamiento.enums.Estado;
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
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEspacio;
    @Column(nullable = false)
    Integer numeroEspacio;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Estado estado;
}
