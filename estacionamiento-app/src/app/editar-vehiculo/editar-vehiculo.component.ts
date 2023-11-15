import { Component } from '@angular/core';
import { Vehiculo } from '../vehiculo';
import { VehiculoService } from '../vehiculo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-vehiculo',
  templateUrl: './editar-vehiculo.component.html'
})
export class EditarVehiculoComponent {
  vehiculo: Vehiculo = new Vehiculo();
  id: number;

  constructor(private vehiculoServicio: VehiculoService,
    private ruta: ActivatedRoute,
    private enrutador: Router){
  }

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.vehiculoServicio.obtenerVehiculoId(this.id).subscribe(
      {
        next: (datos) => this.vehiculo = datos,
        error: (errores: any) => console.log(errores)
      }
    );
  }

  onSubmit(){
    this.editarVehiculo();
  }

  editarVehiculo(){
    this.vehiculoServicio.editarVehiculoId(this.vehiculo,this.id).subscribe({
      next: (datos) => this.enrutador.navigate(['cliente-lista']),
      error: (errores:any) => console.log(errores)
    });
  }
}
