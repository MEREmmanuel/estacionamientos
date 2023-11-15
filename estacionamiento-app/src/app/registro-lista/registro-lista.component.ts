import { Component } from '@angular/core';
import { Registro } from '../registro';
import { RegistroService } from '../registro.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro-lista',
  templateUrl: './registro-lista.component.html'
})
export class RegistroListaComponent {
  registros: Registro[];

  constructor(private registroServicio: RegistroService,
    private enrutador: Router){}
  ngOnInit(){
    this.obtenerRegistros();
  }

  obtenerRegistros(){
    this.registroServicio.obtenerRegistrosLista().subscribe(
      {
        next: (datos) => this.registros = datos,
        error: (errores:any) => console.log(errores)
      }
    );
  }
}
