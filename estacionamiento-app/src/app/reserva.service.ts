import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reserva } from './reserva';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private urlBase = "http://localhost:8080/estacionamiento-app/reservas";

  constructor(private clienteHttp: HttpClient) {}

  obtenerReservasLista(): Observable<Reserva[]>{
    return this.clienteHttp.get<Reserva[]>(this.urlBase);
  }

  registrarReserva(reserva: Reserva): Observable <Object>{
    return this.clienteHttp.post(this.urlBase, reserva);
  }

  obtenerReservaId(id: number){
    return this.clienteHttp.get<Reserva>(`${this.urlBase}/${id}`)
  }

  editarReservaId(reserva: Reserva, id: number): Observable<Object>{
    return this.clienteHttp.put(`${this.urlBase}/${id}`,reserva)
  }

  eliminarReservaId(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/${id}`)
  }
}
