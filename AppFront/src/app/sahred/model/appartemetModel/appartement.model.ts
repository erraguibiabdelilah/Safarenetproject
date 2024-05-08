
import {CategoriesAppartement} from "./categories-appartement.model";
import {Reservation} from "../communModel/reservation.model";
import {PropAppartement} from "./prop-appartement.model";
import {FileHandle} from "../file-handle.model";
export class Appartement {
  id:number;
  code: string;
  superficie: number;
  adresse: string;
  loyerMensuel: number;
  ville: string;
  wifi: string;
  nmbrPersont: number;
  climatiseur: string;
  images: FileHandle[];
  categoriesAppartementDto: CategoriesAppartement;
  propAppartemenetDto: PropAppartement;
  constructor() {
    this.id=0;
    this.code = "";
    this.superficie = 0;
    this.adresse = "";
    this.loyerMensuel = 0;
    this.ville="";
    this.wifi="";
    this.nmbrPersont=0;
    this.climatiseur="";
    this.images=[]
    this.categoriesAppartementDto = {
      id:0,
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
      username : "",
      password:""
    };
  }
}
