import {CategorieVoiture} from "./categorie-voiture.model";
import {AgenceLocation} from "./agence-location.model";

export class Voiture {
  couleur:string;
  photo:string;
  nbrPlace:string;
  matricule:string;
  kiloMetrage:string;
  boitevitesse:string;
  annee:number;
  ville:string;
  dateMisecirculation:Date;
  dateAssurance:Date;
  sateVisitetechnique:Date;
  nomModele:string;
  categorie!:CategorieVoiture;
  agenceLocation!:AgenceLocation;
  prix!:number;
  puissance:number;
  Carburant:string;

  constructor(){
    this.couleur = "";
    this.photo = "";
    this.nbrPlace = "";
    this.matricule = "";
    this.kiloMetrage = "";
    this.boitevitesse = "";
    this.annee = 0;
    this.ville = "";
    this.dateMisecirculation = new Date();
    this.dateAssurance = new Date();
    this.sateVisitetechnique = new Date();
    this.nomModele="";
    this.puissance=0;
    this.Carburant="";

  }
}
