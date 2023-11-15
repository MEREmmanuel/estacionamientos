package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Vehiculo;
import gm.estacionamiento.repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehiculoServicio implements IVehiculoServicio{
    @Autowired
    VehiculoRepositorio vehiculoRepositorio;
    @Override
    public List<Vehiculo> listarVehiculos() {
        return this.vehiculoRepositorio.findAll();
    }

    @Override
    public Vehiculo buscarVehiculoPorId(Integer idVehiculo) {
        return this.vehiculoRepositorio.findById(idVehiculo).orElse(null);
    }

    @Override
    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return this.vehiculoRepositorio.save(vehiculo);
    }

    @Override
    public void eliminarVehiculoPorId(Integer idVehiculo) {
        this.vehiculoRepositorio.deleteById(idVehiculo);
    }

    @Override
    public Vehiculo buscarVehiculoPorCliente(Integer idCliente){
        return this.vehiculoRepositorio.findByCliente(idCliente);
    }
}
