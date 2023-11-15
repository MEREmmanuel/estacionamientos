package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Registro;
import gm.estacionamiento.repositorio.RegistroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistroServicio implements IRegistroServicio{
    @Autowired
    RegistroRepositorio registroRepositorio;
    @Override
    public List<Registro> listarRegistros() {
        return this.registroRepositorio.findAll();
    }

    @Override
    public Registro buscarRegistroPorId(Integer idRegistro) {
        return this.registroRepositorio.findById(idRegistro).orElse(null);
    }

    @Override
    public Registro guardarRegistro(Registro registro) {
        return this.registroRepositorio.save(registro);
    }

    @Override
    public void eliminarRegistroPorId(Integer idRegistro) {
        this.registroRepositorio.deleteById(idRegistro);
    }
}
