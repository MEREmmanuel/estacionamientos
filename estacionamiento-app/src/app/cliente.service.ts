import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Cliente } from './cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlBase = "http://localhost:8080/estacionamiento-app/clientes";

  constructor(private clienteHttp: HttpClient) {}

  obtenerClientesLista(): Observable<Cliente[]>{
    return this.clienteHttp.get<Cliente[]>(this.urlBase);
  }

  registrarCliente(cliente: Cliente): Observable <Object>{
    return this.clienteHttp.post(this.urlBase, cliente);
  }

  obtenerClienteId(id: number){
    return this.clienteHttp.get<Cliente>(`${this.urlBase}/${id}`)
  }

  editarClienteId(cliente: Cliente, id: number): Observable<Object>{
    return this.clienteHttp.put(`${this.urlBase}/${id}`,cliente)
  }

  eliminarClienteId(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/${id}`)
  }
}
