import { Cliente } from "./cliente";
import { Espacio } from "./espacio";

export class Reserva {
    idReserva: number;
    cliente: Cliente;
    espacio: Espacio;
    inicioFechaHora: Date;
    finFechaHora: Date;
}
