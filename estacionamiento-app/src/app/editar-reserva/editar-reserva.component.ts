import { Component } from '@angular/core';
import { Reserva } from '../reserva';
import { ReservaService } from '../reserva.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-reserva',
  templateUrl: './editar-reserva.component.html'
})
export class EditarReservaComponent {
  reserva: Reserva = new Reserva();
  id: number;

  constructor(private reservaServicio: ReservaService,
    private ruta: ActivatedRoute,
    private enrutador: Router) { }

  ngOnInit(){
    this.id = this.ruta.snapshot.params['id'];
    this.reservaServicio.obtenerReservaId(this.id).subscribe(
      {
        next: (datos) => this.reserva=datos,
        error: (errores:any) => console.log(errores)
      }
    );
  }

  onSubmit(){
    this.editarReserva();
  }

  editarReserva(){
    this.reservaServicio.editarReservaId(this.reserva,this.id).subscribe(
      {
        next: (datos) => this.irReservaLista(),
        error: (error:any) => console.log(error)
      }
    );
  }

  irReservaLista(){
    this.enrutador.navigate(['/reserva-lista']);
  }
}
