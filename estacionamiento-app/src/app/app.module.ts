import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrarClienteComponent } from './registrar-cliente/registrar-cliente.component';
import { FormsModule } from '@angular/forms';
import { EditarClienteComponent } from './editar-cliente/editar-cliente.component';
import { EspacioListaComponent } from './espacio-lista/espacio-lista.component';
import { RegistrarReservaComponent } from './registrar-reserva/registrar-reserva.component';
import { ReservaListaComponent } from './reserva-lista/reserva-lista.component';
import { EditarReservaComponent } from './editar-reserva/editar-reserva.component';
import { RegistroListaComponent } from './registro-lista/registro-lista.component';
import { VehiculoClienteComponent } from './vehiculo-cliente/vehiculo-cliente.component';
import { EditarVehiculoComponent } from './editar-vehiculo/editar-vehiculo.component';

@NgModule({
  declarations: [
    AppComponent,
    ClienteListaComponent,
    RegistrarClienteComponent,
    EditarClienteComponent,
    EspacioListaComponent,
    RegistrarReservaComponent,
    ReservaListaComponent,
    EditarReservaComponent,
    RegistroListaComponent,
    VehiculoClienteComponent,
    EditarVehiculoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
