export class Reservation {
<<<<<<< HEAD
=======
   ref:string;
  dateDebut:string;
  heureDebut:string;
  dateFin:string;
  heureFin:string;
  lieuPrise: string;
  lieuRetour: string;
  description:string;
  voiture:Voiture;
  client: Client;
  appartement: Appartement;

   constructor() {
     this.ref="";
     this.dateDebut="";
     this.heureDebut="";
     this.dateFin ="";
     this.heureFin="";
     this.lieuPrise= "";
     this.lieuRetour= "";
     this.description="";
     this.voiture=new Voiture();
     this.client= new Client();
     this.appartement=new Appartement();
   }
>>>>>>> 6007e75cbbde879de4b899fcd88d62566b75c174
}
