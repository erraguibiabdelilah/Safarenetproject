import {Component, OnInit} from '@angular/core';
import {Voiture} from "../../sahred/model/voitureModel/voiture.model";
import {CategoriesAppartement} from "../../sahred/model/appartemetModel/categories-appartement.model";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {VoitureService} from "../../sahred/service/voitureService/voiture.service";
import {CategoriesAppartementService} from "../../sahred/service/appartemetService/categories-appartement.service";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{



  // Variale
  public obejetClicked:boolean=true;
  public formatcard:boolean=false;
  public isClicked:boolean=false;
  public selected:boolean =true;

  // Variable Voiture
  public dataVoiture:Array<Voiture>=new Array<Voiture>();


  // Variable Apparetement
  public dataCategorieApartement:Array<CategoriesAppartement>=new Array<CategoriesAppartement>();
  public dataApartement:Array<Appartement>=new Array<Appartement>();
  public selecCategorieApt:any;
  constructor(private voitureService:VoitureService , private categoreieappartemetService:CategoriesAppartementService ,
              private apartement:AppartemetService,private router:Router) {
  }


  ngOnInit(): void {
    this.getAll();
    this.getAllCategoriesApt();
    this.getAllApartement();
  }

  public clicVoiture() {
    this.obejetClicked=true;
  }
  public clicApp() {
    this.obejetClicked=false;
  }

  handelVertical() {
    this.formatcard=false
  }

  handelHorizental() {
    this.formatcard=true;

  }


  horizentalClic(){
    this.isClicked=true;
  }

  getAll(){
    this.voitureService.getAll().subscribe({
      next:(data)=>{
        this.dataVoiture=data
      },
      error:(err) => console.log(err)
    })
  }





  public  getAllCategoriesApt(){
    this.categoreieappartemetService.getAll().subscribe({
      next:data=>{
        this.dataCategorieApartement=data
      },
      error:err => {
        console.log(err)
      }
    })
  }

  public getAllApartement(){
    this.apartement.getAll().subscribe({
      next:data=>{
        this.dataApartement=data
      },
      error:err => {
        console.log("verfie getAll Apparetement")
      }
    })
  }
  public getAllByCategorierAPT(libelle:string){
    this.apartement.getAppartemetsbyLibelle(libelle).subscribe({
      next:data=>{
        this.dataApartement=data ;
      },
      error:err=>{
        console.log("verifie getByCategorieAppartement");
      }
    })
  }
  onCategorieChange(){
    if(this.selecCategorieApt===""){this.getAllApartement()}
    this.getAllByCategorierAPT(this.selecCategorieApt)
    console.log("dataselectcate====>"+this.selecCategorieApt)
  }


  handelSearch() {
    this.selected=false;
  }

  handelPrev() {
    this.selected=true;
  }
}








