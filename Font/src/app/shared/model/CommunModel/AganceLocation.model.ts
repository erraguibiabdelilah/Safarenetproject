import {Voiture} from "./Voiture.model";

export class AganceLocation{
  public  iceAgLoc :number;
  public  raisonSocialAg :string;
  public  adresse :string;
  public  numTelephone :number;
  public  numCompteBkAgLoc :number;
  public  ribAgenceLoc :number;
  public  usernameAgenceLoc :string;
  public  password :string;
  public  RCAgLoc :number;


  constructor() {
    this.iceAgLoc = 0;
    this.raisonSocialAg = "";
    this.adresse = "";
    this.numTelephone = 0;
    this.numCompteBkAgLoc = 0;
    this.ribAgenceLoc = 0;
    this.usernameAgenceLoc = "";
    this.password = "";
    this.RCAgLoc = 0;
  }
}
