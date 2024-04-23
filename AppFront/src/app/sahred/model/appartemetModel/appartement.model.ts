
import {CategoriesAppartement} from "./categories-appartement.model";
import {Reservation} from "../communModel/reservation.model";
import {PropAppartement} from "./prop-appartement.model";
export class Appartement {
  code: string;
  superficie: number;
  adresse: string;
  loyerMensuel: number;
  reservationDto: Reservation;
  categoriesAppartementDto: CategoriesAppartement;
  propAppartemenetDto: PropAppartement;
  constructor() {
    this.code = "";
    this.superficie = 0;
    this.adresse = "";
    this.loyerMensuel = 0;
    this.reservationDto = {};
    this.categoriesAppartementDto = {
      libelle:""
    };
    this.propAppartemenetDto= {
      nom : "",
      prenom : "",
      numTele : "",
      email : "",
      ribPropAppt : "",
      numCompteBkPropApp : "",
      cin : "",
      usernamePropAppt : "",
      password:""
    };
  }
}
