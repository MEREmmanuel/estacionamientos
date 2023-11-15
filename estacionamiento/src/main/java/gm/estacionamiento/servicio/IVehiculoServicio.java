package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Vehiculo;

import java.util.List;

public interface IVehiculoServicio {
    public List<Vehiculo> listarVehiculos();

    public Vehiculo buscarVehiculoPorId(Integer idVehiculo);

    public Vehiculo guardarVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculoPorId(Integer idVehiculo);

    public Vehiculo buscarVehiculoPorCliente(Integer idCliente);
}