import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Espacio } from './espacio';

@Injectable({
  providedIn: 'root'
})
export class EspacioService {
  private urlBase = "http://localhost:8080/estacionamiento-app/espacios";

  constructor(private clienteHttp: HttpClient) {}

  obtenerEspaciosLista(): Observable<Espacio[]>{
    return this.clienteHttp.get<Espacio[]>(this.urlBase);
  }

}
