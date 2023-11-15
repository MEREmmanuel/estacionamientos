import { Espacio } from "./espacio";
import { Vehiculo } from "./vehiculo";

export class Registro {
    idRegistro: number;
    vehiculo: Vehiculo;
    espacio: Espacio;
    entradaFechaHora: Date;
    salidaFechaHora: Date;
}
