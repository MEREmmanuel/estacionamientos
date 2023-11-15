import { Component } from '@angular/core';
import { Espacio } from '../espacio';
import { Router } from '@angular/router';
import { EspacioService } from '../espacio.service';

@Component({
  selector: 'app-espacio-lista',
  templateUrl: './espacio-lista.component.html'
})
export class EspacioListaComponent {
  espacios: Espacio[];

  constructor(private espacioServicio: EspacioService,
    private enrutador: Router){

  }

  ngOnInit(){
    //Cargas los espacios
    this.obtenerEspacios();
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
