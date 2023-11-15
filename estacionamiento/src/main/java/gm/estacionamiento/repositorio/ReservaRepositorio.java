package gm.estacionamiento.repositorio;

import gm.estacionamiento.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepositorio extends JpaRepository<Reserva,Integer> {
}
