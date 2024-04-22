import {Voiture} from "./Voiture.model";
import {ClientRequest} from "node:http";
import {Appartement} from "../appartementModel/appartement.model";
import {Client} from "../CommunModel/Client.model";

export class Reservation {
  public ref:string;
  public DateDebut:Date;
  public HeureDebut:Date;

  public DateFin:Date;
  public HeureFin:Date;
  public LieuPrise:string;
  public LieuRetour:string;

  public Description:string;
  public voiture!:Voiture;

  public client!:Client;


  public appartement!:Appartement;


  constructor() {
    this.ref = "";
    this.DateDebut = new Date();
    this.HeureDebut =  new Date();
    this.DateFin =  new Date();
    this.HeureFin =  new Date();
    this.LieuPrise = "";
    this.LieuRetour = "";
    this.Description = "";

  }
}
