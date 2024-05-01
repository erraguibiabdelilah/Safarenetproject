import {Component, OnInit} from '@angular/core';
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";
import {DataViewModule} from "primeng/dataview";
import {VoitureService} from "../../sahred/service/voitureService/voiture.service";
import {Voiture} from "../../sahred/model/voitureModel/voiture.model";
import {CategoriesAppartementService} from "../../sahred/service/appartemetService/categories-appartement.service";
import {CategoriesAppartement} from "../../sahred/model/appartemetModel/categories-appartement.model";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgClass,
    DropdownModule,
    FormsModule,
    DataViewModule,
    NgForOf
  ],
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  // Variale
  public obejetClicked:boolean=true;
  public formatcard:boolean=false;
  public isClicked:boolean=false;

  // Variable Voiture
  public dataVoiture:Array<Voiture>=new Array<Voiture>();


  // Variable Apparetement
  public dataCategorieApartement:Array<CategoriesAppartement>=new Array<CategoriesAppartement>();
  public dataApartement:Array<Appartement>=new Array<Appartement>();
  public dataApartement2:Array<Appartement>=new Array<Appartement>();
  public selecCategorieApt:any;
  public dataByPrixApparetement:Array<Appartement>=new Array<Appartement>();


  constructor(private voitureService:VoitureService , private categoreieappartemetService:CategoriesAppartementService ,
              private apartement:AppartemetService) {
  }


  ngOnInit(): void {
    this.getAll();
    this.getAllCategoriesApt();
    this.getAllApartement();
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
        this.dataApartement2=data
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
        this.dataApartement2=data;
      },
      error:err=>{
        console.log("verifie getByCategorieAppartement");
      }
    })
  }
  public onCategorieChange(){
    if(this.selecCategorieApt == ""){this.getAllApartement()}
    else{
      // this.getAllApartement()
      this.getAllByCategorierAPT(this.selecCategorieApt)
    }

    console.log("dataselectcate====>"+this.selecCategorieApt)
  }
  public apparetementByMontant(){
    if(this.villSelected == ''){
      this.onCategorieChange()
      // if(this.selecCategorieApt===""){
      //   this.getAll();
      // }else{
      //   this.getAllByCategorierAPT(this.selecCategorieApt);
      // }
    }else {
      alert(this.villSelected)
      this.dataApartement = this.dataApartement2
      this.dataApartement = this.dataApartement.filter(appartement => appartement.adresse === this.villSelected);
    }
  }
  ville: any[] =[ "Agadire","Safi","Zagora", "Rabat"];
  villSelected!:string;








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


}
