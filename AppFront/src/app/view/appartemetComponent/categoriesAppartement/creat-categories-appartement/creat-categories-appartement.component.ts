// import {Component, OnInit} from '@angular/core';
// import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
// import {
//   CategoriesAppartementService
// } from "../../../../sahred/service/appartemetService/categories-appartement.service";
// import { Appartement } from '../../../../sahred/model/appartemetModel/appartement.model';
// import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
// import {Router} from "@angular/router";
// import {AuthService} from "../../../../security/serviceAuth/auth.service";
//
// @Component({
//   selector: 'app-creat-categories-appartement',
//   templateUrl: './creat-categories-appartement.component.html',
//   styleUrl: './creat-categories-appartement.component.css'
// })
// export class CreatCategoriesAppartementComponent implements OnInit {
//
//   public _ok: boolean = false;
//
//   public propUpdate!: CategoriesAppartement;
//
//   constructor(public authService :AuthService ,public _categoriesAppartementService: CategoriesAppartementService, public _appartementService: AppartemetService, private router: Router) {
//   }
//
//   public save() {
//     this._categoriesAppartementService.save().subscribe({
//       next: response => {
//         console.log(response)
//         if (response === -1) {
//         } else if (response === -2) {
//         } else if (response === -3) {
//         } else if (response === 1) {
//           this._ok = true
//           setTimeout(() => {
//             this._ok = false;
//           }, 10000);
//
//           this.getAll();
//         }
//       },
//       error: (err) => {
//         console.log(err)
//       }
//     });
//   }
//
//
//   public getAll() {
//     this._categoriesAppartementService.getAll().subscribe({
//       next: data => {
//         this.items = data
//       },
//       error: err => {
//         console.log(err)
//       }
//     })
//   }
//
//
//   public getAppartemetsbyLibelle(libelle: String) {
//     this._appartementService.getAppartemetsbyLibelle(libelle).subscribe({
//       next: (data: Appartement[])=>{
//         this._categoriesAppartementService._appartemetsByCategories=data
//         this.router.navigateByUrl("/listAppartemetCompoent")
//
//       },
//       error:(err: any) => {
//         console.log(err)
//       }
//     })
//   }
//   public  delete(libelle:String){
//     this._categoriesAppartementService.delete(libelle).subscribe({
//       next:() => {
//         this.getAll();
//       },
//       error:(err: any) => {
//         console.log(err)
//       }
//     })
//   }
//
//
//   public  update():any{
//     return this._categoriesAppartementService.update(this.propUpdate).subscribe({
//       next:()=>{
//         this.getAll();
//       },
//       error:()=>{
//
//       }
//
//     })
//
//   }
//
//
//
//   get item(): CategoriesAppartement {
//     return this._categoriesAppartementService.item;
//   }
//
//   set item(value: CategoriesAppartement) {
//     this._categoriesAppartementService.item = value;
//   }
//
//
//   get items(): Array<CategoriesAppartement> {
//     return this._categoriesAppartementService._items;
//   }
//
//   set items(value: Array<CategoriesAppartement>) {
//     this._categoriesAppartementService._items = value;
//   }
//
//
//
//
//   ngOnInit(): void {
//     this.getAll();
//     console.log("accessToken")
//     console.log(this.authService.accessToken)
//     console.log("accessTokenEz")
//     console.log(this.authService.accessTokenEz)
//   }
//
// }



import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
import {
  CategoriesAppartementService
} from "../../../../sahred/service/appartemetService/categories-appartement.service";
import { Appartement } from '../../../../sahred/model/appartemetModel/appartement.model';
import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
import {AuthService} from "../../../../security/serviceAuth/auth.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {VoitureService} from "../../../../sahred/service/voitureService/voiture.service";
import html2canvas from "html2canvas";
import {Voiture} from "../../../../sahred/model/voitureModel/voiture.model";
// @ts-ignore
import jsPDF from 'jspdf';
import {content} from "html2canvas/dist/types/css/property-descriptors/content";
import {response} from "express";
@Component({
  selector: 'app-creat-categories-appartement',
  templateUrl: './creat-categories-appartement.component.html',
  styleUrl: './creat-categories-appartement.component.css'
})
export class CreatCategoriesAppartementComponent implements OnInit ,AfterViewInit{
  public dataSource!: MatTableDataSource<any>;

  public display:boolean = false;
  public submitted:boolean=false;



  public displayedColumns = [
    "id", "libelle","action"
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;


  selectedCategorieItem: CategoriesAppartement ={
    "id":0,"libelle":""
  };

  isEdit :boolean=false;
  isCreate :boolean=false;


  constructor(private categoriesAppartementService:CategoriesAppartementService) {
  }

  ngOnInit(): void {
    this.viderItemSelected();
    this.getAll()
  }


  creatCategorie() {
    this.isCreate=true
    this.isEdit=false;
    this.viderItemSelected();
    this.display = true;
  }

  saveObject() {
    this.save();
    this.submitted = true;
    this.display=false;
  }


  hideDialog() {
    this.viderItemSelected();
    this.display=false;
    this.submitted = false;
  }

  exportToPDF() {
    const content = document.getElementById('content');
    // @ts-ignore
    html2canvas(content).then(canvas => {
      const imgData = canvas.toDataURL('image/png');
      const pdf = new jsPDF();

      const imgWidth = 210; // Largeur de la page A4
      const imgHeight = canvas.height * imgWidth / canvas.width;

      pdf.addImage(imgData, 'PNG', 0, 0, imgWidth, imgHeight);
      pdf.save('export.pdf');
    });
  }


  editCategorie(element:CategoriesAppartement) {
    this.isCreate=false;
    this.isEdit=true
    this.selectedCategorieItem = Object.assign({}, element);
    this.display = true;
  }


  updateObject() {
    console.log(this.selectedCategorieItem)
    console.log(this.item)
    let data={
      "libelle": this.selectedCategorieItem.libelle,
      "libelleNew": this.item.libelle
    }
    this.categoriesAppartementService.update(data).subscribe({
      next:data=>{
        console.log(data)
        if(data==1){
          this.getAll();
          this.display=false;
        }else {
          console.log("error")
        }

      },
      error:err => {
        console.log(data)
      }
    })

  }

  search(event: Event) {
    console.log(event)
    let value=(event.target as HTMLInputElement).value;
    this.dataSource.filter=value
  }


  //crud

  //1-save
  public save() {
    this.categoriesAppartementService.save().subscribe({
      next: response => {
        console.log(response)
        if (response === -1) {
        } else if (response === -2) {
        } else if (response === -3) {
        } else if (response === 1) {
          this.getAll();
        }
      },
      error: (err) => {
        console.log(err)
      }
    });
  }


  //2-getAll
  public getAll() {
    this.categoriesAppartementService.getAll().subscribe({
      next: data => {
        this.items = data
        this.dataSource=new MatTableDataSource(this.items);
        if(this.dataSource.paginator&&this.dataSource.sort){
          this.dataSource.paginator=this.paginator;
          this.dataSource.sort=this.sort;
        }
      },
      error: err => {
        console.log(err)
      }
    })
  }


  public  delete(libelle:String){
    this.categoriesAppartementService.delete(libelle).subscribe({
      next:() => {
        this.getAll();
      },
      error:(err: any) => {
        console.log(err)
      }
    })
  }


  viderItemSelected(){
    this.selectedCategorieItem={
      "id":0,"libelle":""
    }
  }




  get item(): CategoriesAppartement {
    return this.categoriesAppartementService.item;
  }

  set item(value: CategoriesAppartement) {
    this.categoriesAppartementService.item = value;
  }


  get items(): Array<CategoriesAppartement> {
    return this.categoriesAppartementService._items;
  }

  set items(value: Array<CategoriesAppartement>) {
    this.categoriesAppartementService._items = value;
  }

  ngAfterViewInit(): void {
    // this.dataSource.paginator= this.paginator;
    // this.dataSource.sort=this.sort;
  }


  protected readonly event = event;
}
