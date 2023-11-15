package gm.estacionamiento.repositorio;

import gm.estacionamiento.modelo.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspacioRepositorio extends JpaRepository<Espacio,Integer> {
}
