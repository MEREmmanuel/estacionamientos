package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Registro;

import java.util.List;

public interface IRegistroServicio {
    public List<Registro> listarRegistros();
    public Registro buscarRegistroPorId(Integer idRegistro);
    public Registro guardarRegistro(Registro registro);
    public void eliminarRegistroPorId(Integer idRegistro);
}
