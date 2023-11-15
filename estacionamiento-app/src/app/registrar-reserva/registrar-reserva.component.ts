import { Component } from '@angular/core';
import { Reserva } from '../reserva';
import { ReservaService } from '../reserva.service';
import { Router } from '@angular/router';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente';
import { EspacioService } from '../espacio.service';
import { Espacio } from '../espacio';

@Component({
  selector: 'app-registrar-reserva',
  templateUrl: './registrar-reserva.component.html'
})
export class RegistrarReservaComponent {
  reserva: Reserva = new Reserva();
  clientes: Cliente[];
  espacios: Espacio[];

  constructor(private reservaServicio: ReservaService,
    private enrutador: Router, private clienteServicio: ClienteService,
    private espacioServicio: EspacioService) { }

  onSubmit() {
    //Registrar la reserva
    this.registrarReserva();
  }

  ngOnInit(){
    this.obtenerClientes();
    this.obtenerEspacios();
  }

  registrarReserva() {
    //Consumir el observable
    this.reservaServicio.registrarReserva(this.reserva).subscribe(
      {
        next: (datos) => {
          this.irReservaLista();
        },
        error: (error: any) => {
          console.log(error)
        }
      }
    );
  }

  irReservaLista() {
    this.enrutador.navigate(['/cliente-lista'])
  }

  obtenerClientes(){
    //Consumir los datos del observable
    this.clienteServicio.obtenerClientesLista().subscribe(
      (datos => {
        this.clientes = datos;
      })
    );
  }

  obtenerEspacios(){
    //Consumir los datos del observable
    this.espacioServicio.obtenerEspaciosLista().subscribe(
      (datos => {
        this.espacios = datos;
      })
    );
  }
}
