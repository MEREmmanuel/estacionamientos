import { Component } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrar-cliente',
  templateUrl: './registrar-cliente.component.html'
})
export class RegistrarClienteComponent {
  cliente: Cliente = new Cliente();

  constructor(private clienteServicio: ClienteService,
    private enrutador: Router) { }

  onSubmit() {
    //Registrar el cliente
    this.registrarCliente();
  }

  registrarCliente() {
    //Consumir el observable
    this.clienteServicio.registrarCliente(this.cliente).subscribe(
      {
        next: (datos) => {
          this.irClienteLista();
        },
        error: (error: any) => {
          console.log(error)
        }
      }
    );
  }

  irClienteLista() {
    this.enrutador.navigate(['/cliente-lista'])
  }
}
