import {Modele} from "./Modele.model";
import {Categorie} from "./Categorie.model";
import {AganceLocation} from "./AganceLocation.model";


export class Voiture extends Modele{
  public  couleur :string;
  public  photo :string;

  public   nbrPlace : number;

  public  matricule :string;

  public  kiloMetrage : number;
  public  boitevitesse :string;

  public  annee:Date;

  public  ville :string;
  public  dateMisecirculation :Date;

  public  dateAssurance :Date;
  public  sateVisitetechnique :Date;

  public categorie:Categorie;
  public agenceLocation :AganceLocation;


  constructor() {
    super();
    this.couleur = "";
    this.photo = "";
    this.nbrPlace = 0;
    this.matricule = "";
    this.kiloMetrage = 0;
    this.boitevitesse = "";
    this.ville = "";
    this.annee = new Date(); // Initialisation à la date courante
    this.dateMisecirculation = new Date(); // Initialisation à la date courante
    this.dateAssurance = new Date(); // Initialisation à la date courante
    this.sateVisitetechnique = new Date
    this.categorie = {libelle:""};
    this.agenceLocation = {    iceAgLoc : 0,
      raisonSocialAg : "",
      adresse : "",
      numTelephone : 0,
      numCompteBkAgLoc : 0,
      ribAgenceLoc : 0,
      usernameAgenceLoc : "",
      password : "",
      RCAgLoc : 0};
  }
}
