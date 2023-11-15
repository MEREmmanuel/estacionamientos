import { Injectable } from '@angular/core';
import { Registro } from './registro';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistroService {
  private urlBase = "http://localhost:8080/estacionamiento-app/registros";

  constructor(private clienteHttp: HttpClient) {}

  obtenerRegistrosLista(): Observable<Registro[]>{
    return this.clienteHttp.get<Registro[]>(this.urlBase);
  }
}
