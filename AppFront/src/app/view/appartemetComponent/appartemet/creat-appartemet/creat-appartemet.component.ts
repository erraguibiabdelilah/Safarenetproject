import { Component } from '@angular/core';
import {Appartement} from "../../../../sahred/model/appartemetModel/appartement.model";
import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
import {PropAppartement} from "../../../../sahred/model/appartemetModel/prop-appartement.model";
import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
import {
  CategoriesAppartementService
} from "../../../../sahred/service/appartemetService/categories-appartement.service";
import {PropAppartementService} from "../../../../sahred/service/appartemetService/prop-appartement.service";

@Component({
  selector: 'app-creat-appartemet',
  templateUrl: './creat-appartemet.component.html',
  styleUrl: './creat-appartemet.component.css'
})
export class CreatAppartemetComponent {


  public _ok:boolean=false;

  public  propUpdate!:Appartement;

  public  categorits : CategoriesAppartement[]=[]

  public  categoriesString: string[]=[]

  public selectedCategory: string="";

  public  propAppartements! :PropAppartement[]

  public  propString : string[]=[]
  public  selectedProp :string=""
  constructor(public appartemetService :AppartemetService,public categorieService:CategoriesAppartementService,public  propAppartement:PropAppartementService) {
  }

  public save() {
    this.item.categoriesAppartementDto.libelle=this.selectedCategory
    this.item.propAppartemenetDto.cin=this.selectedProp
    this.service.save().subscribe({

      next: (response: number) => {

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

          this.getAll();

        }
      },
      error: () => {
        // Gérer les erreurs
      }
    });
  }


  public  getAll(){
    this.appartemetService.getAll().subscribe({
      next:data=>{
        this.items=data
      },
      error:err => {
        console.log(err)
      }
    })
  }



  public  getCategoriesLibelle(){
    this.categorieService.getAll().subscribe(
      {
        next:data=>{
          this.categorits=data
          this.categorits.map(c=>{
            this.categoriesString.push(c.libelle.toString())
          })
        }
      }
    )
  }

  public  getPropCin(){
    this.propAppartement.getAll().subscribe(
      {
        next:data=>{
          this.propAppartements=data
          this.propAppartements.map(c=>{
            this.propString.push(c.cin.toString())
          })
        }
      }
    )
  }


  public  delete(cin:string){
    this.appartemetService.delete(cin).subscribe({
      next:value => {
        this.getAll();
      },
      error:err => {
        console.log(err)
      }
    })
  }


  public  update():any{
    return this.appartemetService.update(this.propUpdate).subscribe({
      next:()=>{
        this.getAll();
      },
      error:()=>{

      }

    })

  }



  get item(): Appartement {
    return this.appartemetService.item;
  }

  set item(value: Appartement) {
    this.appartemetService.item = value;
  }

  get items(): Array<Appartement> {
    return this.appartemetService._items;
  }

  set items(value: Array<Appartement>) {
    this.appartemetService._items = value;
  }


  get service(): AppartemetService {
    return this.appartemetService;
  }

  set service(value: AppartemetService) {
    this.appartemetService = value;
  }

  ngOnInit(): void {
    console.log(this.items.map(value => console.log(value)))
    this.getAll();
    this.getCategoriesLibelle();
    this.getPropCin();
  }

}
