import {AgenceLocation} from "../voitureModel/agence-location.model";
import {PropAppartement} from "../appartemetModel/prop-appartement.model";
import {Reservation} from "./reservation.model";

export class Client {
  cin: string;
  prenom: string;
  nom: string;
  numTeleClient: string;
  username_Client: string;
  password_Client: string;
  email_Client: string;
  agenceLocation: AgenceLocation;
  propAppartemenetDto: PropAppartement;
  reservationDto!: Array<Reservation>;




  constructor() {
    this.cin = "";
    this.prenom = "";
    this.nom = "";
    this.numTeleClient = "";
    this.username_Client = "";
    this.password_Client = "";
    this.email_Client = "";
    this.agenceLocation = {
      iceAgLoc: 0,
      ribAgenceLoc: 0,
      raisonSocialAg: "",
      adresse: "",
      numTelephone: "",
      numCompteBkAgLoc: 0,
      usernameAgenceLoc: "",
      password: "",
      RCAgLoc: 0
    };
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


  }
}
