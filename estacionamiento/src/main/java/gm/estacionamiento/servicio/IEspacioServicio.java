package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Espacio;

import java.util.List;

public interface IEspacioServicio {
    public List<Espacio> listarEspacios();
    public Espacio buscarEspacioPorId(Integer idEspacio);
    public Espacio guardarEspacio(Espacio espacio);
    public void eliminarEspacioPorId(Integer idEspacio);
}
