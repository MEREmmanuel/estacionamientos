import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import { RegistrarClienteComponent } from './registrar-cliente/registrar-cliente.component';
import { EditarClienteComponent } from './editar-cliente/editar-cliente.component';
import { EspacioListaComponent } from './espacio-lista/espacio-lista.component';
import { RegistrarReservaComponent } from './registrar-reserva/registrar-reserva.component';
import { ReservaListaComponent } from './reserva-lista/reserva-lista.component';
import { EditarReservaComponent } from './editar-reserva/editar-reserva.component';
import { RegistroListaComponent } from './registro-lista/registro-lista.component';
import { VehiculoClienteComponent } from './vehiculo-cliente/vehiculo-cliente.component';
import { EditarVehiculoComponent } from './editar-vehiculo/editar-vehiculo.component';

const routes: Routes = [
  { path: 'cliente-lista', component: ClienteListaComponent},
  {path: 'registrar-cliente', component: RegistrarClienteComponent},
  {path: 'editar-cliente/:id',component: EditarClienteComponent},
  {path: 'espacio-lista', component: EspacioListaComponent},
  {path: 'registrar-reserva', component: RegistrarReservaComponent},
  {path: 'reserva-lista', component: ReservaListaComponent},
  {path: 'editar-reserva/:id', component: EditarReservaComponent},
  {path: 'registro-lista', component: RegistroListaComponent},
  {path: 'vehiculo-cliente/:idCliente', component: VehiculoClienteComponent},
  {path: 'editar-vehiculo/:id', component: EditarVehiculoComponent},
  {path: '', redirectTo: 'cliente-lista', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
