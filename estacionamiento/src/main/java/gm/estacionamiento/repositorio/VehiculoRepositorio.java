package gm.estacionamiento.repositorio;

import gm.estacionamiento.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo,Integer> {
    @Query("SELECT v FROM Vehiculo v WHERE v.Cliente.idCliente = :cliente_id_cliente")
    Vehiculo findByCliente(@Param("cliente_id_cliente") Integer idCliente);
}
