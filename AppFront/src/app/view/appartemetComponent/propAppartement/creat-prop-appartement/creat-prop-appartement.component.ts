import {Component, OnInit} from '@angular/core';
import {PropAppartementService} from "../../../../sahred/service/appartemetService/prop-appartement.service";
import {PropAppartement} from "../../../../sahred/model/appartemetModel/prop-appartement.model";
import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-creat-prop-appartement',
  templateUrl: './creat-prop-appartement.component.html',
  styleUrl: './creat-prop-appartement.component.css'
})
export class CreatPropAppartementComponent implements OnInit{

  public _ok:boolean=false;

  constructor(public _service :PropAppartementService,public  _appartementService:AppartemetService,private router:Router) {

  }

  get item(): PropAppartement {
    return this._service.item;
  }


  set item(value: PropAppartement) {
    this._service.item = value;
  }
  public save() {
    this.service.save().subscribe({

      next: (response) => {

        console.log(response)
        if (response === -1) {

        } else if (response === -2) {
          console.log("mohammed l3z!!")
        } else if (response === -3) {
          // Traitement pour le cas où l'enregistrement a échoué avec le code -3
        } else if (response === 1) {

          this._ok = true
          setTimeout(() => {
            this._ok = false; // Hide the notification after 5 seconds
          }, 10000);

          this.get();

        }
      },
      error: (err) => {
        // Gérer les erreurs
      }
    });
  }


  public  get(){
    this._service.getAll().subscribe({
      next:data=>{
        this.items=data
      },
      error:err => {
        console.log(err)
      }
    })
  }

  public  delete(cin:string){
    this._service.delete(cin).subscribe({
      next:value => {
        this.get();
      },
      error:err => {
        console.log(err)
      }
    })
  }

  public  getAppartemetsbyCin(cin:String){
    this._appartementService.getAppartemetsCin(cin).subscribe({
      next:data=>{
        // console.log(data)
        this._service._appartemetsByCin=data
        console.log(this._service._appartemetsByCin)
        this.router.navigateByUrl("/listComponent")

      },
      error:err => {
        console.log(err)
      }
    })
  }


  public  update(cin :string):any{

// this._service.cinEdit=cin
//     console.log(this._service.cinEdit)
    // this.router.navigateByUrl("editProp")
    // this._service.update(this.item).subscribe(
    //   {
    //     next :data=>{
    //       console.log("mohammed")
    //       this._ok = true
    //       setTimeout(() => {
    //         this._ok = false; // Hide the notification after 5 seconds
    //       }, 10000);
    //
    //       this.get();
    //     },error:err => {
    //       console.log(err);
    //     }
    //   }
    // )
  }


  get items(): Array<PropAppartement> {
    return this._service._items;
  }

  set items(value: Array<PropAppartement>) {
    this._service._items = value;
  }

  supprimet() {
    this.item.nom="";
    this.item.prenom="";
    this.item.email="";
    this.item.username="";
    this.item.ribPropAppt="";
    this.item.numTele="",
      this.item.numCompteBkPropApp="",
      this.item.cin=""
  }
  get service(): PropAppartementService {
    return this._service;
  }

  set service(value: PropAppartementService) {
    this._service = value;
  }

  ngOnInit(): void {
    this.get();
  }


  // editProp(cin:string) {
  //   this.router.navigateByUrl("editProp")
  // }
}
