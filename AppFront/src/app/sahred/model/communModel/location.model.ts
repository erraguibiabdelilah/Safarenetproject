import {Reservation} from "./reservation.model";

export class Location {

  ref:string;
  reservationDto:Reservation;

  constructor() {
    this.ref = "";
    this.reservationDto = new Reservation();
  }
}
