package gm.estacionamiento.repositorio;

import gm.estacionamiento.modelo.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepositorio extends JpaRepository<Registro,Integer> {
}
