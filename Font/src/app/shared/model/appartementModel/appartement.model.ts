import {CategoriesAppartement} from "./categories-appartement.model";
import {PropAppartement} from "./propAppartemenet.model";
import {Reservation} from "../voitureModel/reservation.model";

export class Appartement {
  code: string;
  superficie: number;
  adresse: string;
  loyerMensuel: number;
  reservationDto: Reservation;
  categoriesAppartementDto: CategoriesAppartement;
  propAppartemenetDto: PropAppartement;

  constructor(code: string, superficie: number, adresse: string, loyerMensuel: number, reservationDto: Reservation, categoriesAppartementDto: CategoriesAppartement, propAppartemenetDto: PropAppartement) {
    this.code = code;
    this.superficie = superficie;
    this.adresse = adresse;
    this.loyerMensuel = loyerMensuel;
    this.reservationDto = reservationDto;
    this.categoriesAppartementDto = categoriesAppartementDto;
    this.propAppartemenetDto = propAppartemenetDto;
  }
}
