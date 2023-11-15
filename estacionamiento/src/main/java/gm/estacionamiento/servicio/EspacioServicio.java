package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Espacio;
import gm.estacionamiento.repositorio.EspacioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspacioServicio implements IEspacioServicio{
    @Autowired
    private EspacioRepositorio espacioRepositorio;
    @Override
    public List<Espacio> listarEspacios() {
        return this.espacioRepositorio.findAll();
    }

    @Override
    public Espacio buscarEspacioPorId(Integer idEspacio) {
        return this.espacioRepositorio.findById(idEspacio).orElse(null);
    }

    @Override
    public Espacio guardarEspacio(Espacio espacio) {
        return this.espacioRepositorio.save(espacio);
    }

    @Override
    public void eliminarEspacioPorId(Integer idEspacio) {
        this.espacioRepositorio.deleteById(idEspacio);
    }
}
