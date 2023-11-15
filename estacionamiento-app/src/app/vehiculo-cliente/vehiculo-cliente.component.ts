import { Component } from '@angular/core';
import { Vehiculo } from '../vehiculo';
import { VehiculoService } from '../vehiculo.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-vehiculo-cliente',
  templateUrl: './vehiculo-cliente.component.html'
})
export class VehiculoClienteComponent {
  vehiculo: Vehiculo = new Vehiculo();
  cliente: Cliente = new Cliente();
  idCliente: number;

  constructor(private vehiculoServicio: VehiculoService,
    private clienteServicio: ClienteService,
    private ruta: ActivatedRoute,
    private enrutador: Router){}

  ngOnInit(){
    this.idCliente = this.ruta.snapshot.params['idCliente'];
    this.vehiculoServicio.obtenerVehiculoPorCliente(this.idCliente).subscribe(
      {
        next: (datos) => this.vehiculo = datos,
        error: (error:any) => console.log(error)
      }
    );
    this.obtenerClienteId();
  }

  obtenerClienteId(){
    this.clienteServicio.obtenerClienteId(this.idCliente).subscribe({
      next: (datos) => this.cliente = datos,
      error: (errores:any) => console.log(errores)
    });
  }

  onSubmit(){
    this.registrarVehiculo();
  }

  registrarVehiculo(){
    this.vehiculo.cliente = this.cliente;
    this.vehiculoServicio.registrarVehiculo(this.vehiculo).subscribe(
      {
        next: (datos) => this.enrutador.navigate(['cliente-lista']),
        error: (errores:any) => console.log(errores)
      }
    );
  }

  editarVehiculo(id:number){
    this.enrutador.navigate(['editar-vehiculo',id])
  }

  eliminarVehiculo(id: number){
    this.vehiculoServicio.eliminarVehiculoId(id).subscribe(
      {
        next: (datos) => this.enrutador.navigate(['cliente-lista']),
        error: (errores:any) => console.log(errores)
      }
    );
  }

}
