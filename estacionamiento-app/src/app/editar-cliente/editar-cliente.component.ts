import { Component } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html'
})
export class EditarClienteComponent {
  cliente: Cliente = new Cliente();
  id: number;

  constructor(private clienteServicio: ClienteService,
    private ruta: ActivatedRoute,
    private enrutador: Router) {
  }

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.clienteServicio.obtenerClienteId(this.id).subscribe(
      {
        next: (datos) => this.cliente = datos,
        error: (errores: any) => console.log(errores)
      }
    );
  }

  onSubmit(){
    //Editar el producto
    this.editarCliente();
  }

  editarCliente(){
    this.clienteServicio.editarClienteId(this.cliente, this.id).subscribe(
      {
        next: (datos) => this.irClienteLista(),
        error: (error: 'any') => console.log(error)
      }
    );
  }

  irClienteLista(){
    this.enrutador.navigate(['/cliente-lista'])
  }
}
