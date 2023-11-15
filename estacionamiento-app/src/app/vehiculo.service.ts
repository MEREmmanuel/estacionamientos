import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehiculo } from './vehiculo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {
  private urlBase = "http://localhost:8080/estacionamiento-app/vehiculos";

  constructor(private clienteHttp: HttpClient) {}

  obtenerVehiculoPorCliente(idCliente: number){
    return this.clienteHttp.get<Vehiculo>(`${this.urlBase}Cliente/${idCliente}`);
  }

  registrarVehiculo(vehiculo: Vehiculo): Observable <Object>{
    return this.clienteHttp.post(this.urlBase, vehiculo);
  }

  obtenerVehiculoId(id: number){
    return this.clienteHttp.get<Vehiculo>(`${this.urlBase}/${id}`)
  }

  editarVehiculoId(vehiculo: Vehiculo, id: number): Observable<Object>{
    return this.clienteHttp.put(`${this.urlBase}/${id}`,vehiculo)
  }

  eliminarVehiculoId(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/${id}`)
  }
}
