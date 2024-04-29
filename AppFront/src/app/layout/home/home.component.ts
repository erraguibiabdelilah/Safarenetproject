import {Component, OnInit} from '@angular/core';
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";
import {DataViewModule} from "primeng/dataview";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {VoitureService} from "../../sahred/service/voitureService/voiture.service";
import {Voiture} from "../../sahred/model/voitureModel/voiture.model";

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
  public obejetClicked:boolean=true;
  public formatcard:boolean=false;
  public dataVoiture:Array<Voiture>=new Array<Voiture>();
  public isClicked:boolean=false;
  constructor(private voitureService:VoitureService) {
  }

  ngOnInit(): void {
    this.getAll();
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
}
