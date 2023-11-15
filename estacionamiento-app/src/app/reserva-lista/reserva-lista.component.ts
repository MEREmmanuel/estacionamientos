import { Component } from '@angular/core';
import { Reserva } from '../reserva';
import { ReservaService } from '../reserva.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reserva-lista',
  templateUrl: './reserva-lista.component.html'
})
export class ReservaListaComponent {
  reservas: Reserva[];

  constructor(private reservaServicio: ReservaService,
    private enrutador: Router){

  }

  ngOnInit(){
    //Cargas los clientes
    this.obtenerReservas();
  }

  obtenerReservas(){
    //Consumir los datos del observable
    this.reservaServicio.obtenerReservasLista().subscribe(
      (datos => {
        this.reservas = datos;
      })
    );
  }
  
  editarReserva(id: number){
    this.enrutador.navigate(['editar-reserva',id]);
  }

  eliminarReserva(id: number){
    this.reservaServicio.eliminarReservaId(id).subscribe(
      {
        next: (datos) => this.obtenerReservas(),
        error: (errores:'any') => console.log(errores)
      }
    );
  }
}
