import {Component, OnInit} from '@angular/core';
import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
import {
  CategoriesAppartementService
} from "../../../../sahred/service/appartemetService/categories-appartement.service";
import { Appartement } from '../../../../sahred/model/appartemetModel/appartement.model';
import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
import {Router} from "@angular/router";
import {AuthService} from "../../../../security/serviceAuth/auth.service";

@Component({
  selector: 'app-creat-categories-appartement',
  templateUrl: './creat-categories-appartement.component.html',
  styleUrl: './creat-categories-appartement.component.css'
})
export class CreatCategoriesAppartementComponent implements OnInit {

  public _ok: boolean = false;

  public propUpdate!: CategoriesAppartement;

  constructor(public authService :AuthService ,public _categoriesAppartementService: CategoriesAppartementService, public _appartementService: AppartemetService, private router: Router) {
  }

  public save() {
    this._categoriesAppartementService.save().subscribe({
      next: response => {
        console.log(response)
        if (response === -1) {
        } else if (response === -2) {
        } else if (response === -3) {
        } else if (response === 1) {
          this._ok = true
          setTimeout(() => {
            this._ok = false;
          }, 10000);

          this.getAll();
        }
      },
      error: (err) => {
        console.log(err)
      }
    });
  }


  public getAll() {
    this._categoriesAppartementService.getAll().subscribe({
      next: data => {
        this.items = data
      },
      error: err => {
        console.log(err)
      }
    })
  }


  public getAppartemetsbyLibelle(libelle: String) {
    this._appartementService.getAppartemetsbyLibelle(libelle).subscribe({
      next: (data: Appartement[])=>{
        this._categoriesAppartementService._appartemetsByCategories=data
        this.router.navigateByUrl("/listAppartemetCompoent")

      },
      error:(err: any) => {
        console.log(err)
      }
    })
  }
  public  delete(libelle:String){
    this._categoriesAppartementService.delete(libelle).subscribe({
      next:() => {
        this.getAll();
      },
      error:(err: any) => {
        console.log(err)
      }
    })
  }


  public  update():any{
    return this._categoriesAppartementService.update(this.propUpdate).subscribe({
      next:()=>{
        this.getAll();
      },
      error:()=>{

      }

    })

  }



  get item(): CategoriesAppartement {
    return this._categoriesAppartementService.item;
  }

  set item(value: CategoriesAppartement) {
    this._categoriesAppartementService.item = value;
  }


  get items(): Array<CategoriesAppartement> {
    return this._categoriesAppartementService._items;
  }

  set items(value: Array<CategoriesAppartement>) {
    this._categoriesAppartementService._items = value;
  }




  ngOnInit(): void {
    this.getAll();
    console.log("accessToken")
    console.log(this.authService.accessToken)
    console.log("accessTokenEz")
    console.log(this.authService.accessTokenEz)
  }

}
