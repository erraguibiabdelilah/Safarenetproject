import {AgenceLocation} from "../voitureModel/agence-location.model";
import {PropAppartement} from "../appartemetModel/prop-appartement.model";
import {Facture} from "./facture.model";

export class Paiement {
  ref: string;
  datePaiement: Date;
  ribClient: number;

  agenceLocationDto: AgenceLocation;

  propAppartemenetDto: PropAppartement;

  factureDto: Facture;


  constructor() {
    this.ref = "";
    this.datePaiement = new Date();
    this.ribClient = 0;
    this.agenceLocationDto = {
      iceAgLoc: 0,
      raisonSocialAg: "",
      adresse: "",
      numTelephone: "",
      numCompteBkAgLoc: 0,
      ribAgenceLoc: 0,
      usernameAgenceLoc: "",
      password: "",
      RCAgLoc: 0,
    }
    this.propAppartemenetDto = {
      nom: "",
      prenom: "",
      numTele: "",
      email: "",
      ribPropAppt: "",
      numCompteBkPropApp: "",
      cin: "",
      username: "",
      password: ""

    };

    this.factureDto = new Facture();
  }

}

