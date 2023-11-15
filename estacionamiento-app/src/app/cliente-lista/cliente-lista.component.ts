import { Component } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
})
export class ClienteListaComponent {
  clientes: Cliente[];

  constructor(private clienteServicio: ClienteService,
    private enrutador: Router){
  }

  ngOnInit(){
    //Cargas los clientes
    this.obtenerClientes();
  }

  obtenerClientes(){
    //Consumir los datos del observable
    this.clienteServicio.obtenerClientesLista().subscribe(
      (datos => {
        this.clientes = datos;
      })
    );
  }

  editarCliente(id: number){
    this.enrutador.navigate(['editar-cliente',id]);
  }

  eliminarCliente(id: number){
    this.clienteServicio.eliminarClienteId(id).subscribe(
      {
        next: (datos) => this.obtenerClientes(),
        error: (errores:'any') => console.log(errores)
      }
    );
  }

  vehiculoCliente(id: number){
    this.enrutador.navigate(['vehiculo-cliente',id])
  }
}
