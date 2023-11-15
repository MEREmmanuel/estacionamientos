package gm.estacionamiento.servicio;

import gm.estacionamiento.modelo.Reserva;

import java.util.List;

public interface IReservaServicio {
    public List<Reserva> listarReservas();
    public Reserva buscarReservaPorID(Integer idReserva);
    public Reserva guardarReserva(Reserva reserva);
    public void eliminarReservaPorId(Integer idReserva);
}
