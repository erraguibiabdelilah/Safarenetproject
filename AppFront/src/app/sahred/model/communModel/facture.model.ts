import {Paiement} from "./paiement.model";
import {Location} from "./location.model";

export class Facture {
  ref: string;
  dateFacture: string;
  montantTotal: number;
  location: Location;
  paiementDto:Paiement;
  constructor() {
    this.ref = "";
    this.dateFacture = "";
    this.montantTotal = 0;
    this.location = new Location();
    this.paiementDto =new Paiement();
  }


}
