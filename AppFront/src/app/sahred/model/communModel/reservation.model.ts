import {Voiture} from "../voitureModel/voiture.model";
import {Client} from "./client.model";
import {Appartement} from "../appartemetModel/appartement.model";

export class Reservation {
   ref:string;
  date_Debut:Date;
  heure_Debut:Date;
  date_Fin:Date;
  heure_Fin:Date;
  lieu_Prise: string;
  lieu_Retour: string;
  description:string;
  voiture:Voiture;
  client: Client;
  appartement: Appartement;

   constructor() {
     this.ref="";
     this.date_Debut=new Date();
     this.heure_Debut=new Date();
     this.date_Fin =new Date();
     this.heure_Fin=new Date();
     this.lieu_Prise= "";
     this.lieu_Retour= "";
     this.description="";
     this.voiture=new Voiture();
     this.client= new Client();
     this.appartement=new Appartement();
   }
}
