import {Voiture} from "../voitureModel/voiture.model";
import {Client} from "./client.model";
import {Appartement} from "../appartemetModel/appartement.model";

export class Reservation {
   ref:string;
   DateDebut:Date;
   HeureDebut:Date;
   DateFin:Date;
   HeureFin:Date;
   LieuPrise: string;
   LieuRetour: string;
   Description:string;
   voiture:Voiture;
   client: Client;
   appartement: Appartement;

   constructor() {
     this.ref="";
     this.DateDebut=new Date();
     this.HeureDebut=new Date();
     this.DateFin=new Date();
     this.HeureFin=new Date();
     this.LieuPrise= "";
     this.LieuRetour= "";
     this.Description="";
     this.voiture=new Voiture();
     this.client= new Client();
     this.appartement=new Appartement();
   }
}
