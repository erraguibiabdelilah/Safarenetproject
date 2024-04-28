import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {CategorieVoitureService} from "../../../../sahred/service/voitureService/categorie-voiture.service";
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {Contrat} from "../../../../sahred/model/communModel/contrat.model";
import {ContratService} from "../../../../sahred/service/communService/contrat.service";

@Component({
  selector: 'app-creat-contrat',
  templateUrl: './creat-contrat.component.html',
  styleUrl: './creat-contrat.component.css'
})
 export class CreatContratComponent implements OnInit, AfterViewInit {

  public dataSource!: MatTableDataSource<any>;
  public display:boolean = false;
  public submitted:boolean=false;


  public ListeColum = [
    "numContrat","prixHT","TVA","modelePaiement","dateSignature","dureeRetard","Rest","riflocation","action"
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;

  constructor(private service:ContratService) {
  }



  ngOnInit(): void {
    this.getAll();

    console.log(this.dataSource)
  }



  ngAfterViewInit(): void {
    console.log("this.paginator"+this.paginator)
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort=this.sort;
  }


  public getAll(){
    this.service.getAll().subscribe({
      next:(data)=>{

        this.items=data;
        this.dataSource = new MatTableDataSource<any>(this.items);
        this.dataSource.paginator = this.paginator;
        if(data.length!=0){
          console.log("DATA"+data);
          console.log("this.items"+this.items);
        }
      },
      error:(err)=>{
        console.log('verifier getAll contrat');
      }
    })
  }






  showDialog() {
    this.display = true;
  }

  saveObject() {
    this.service.save().subscribe({
      next:(data)=>{
        if(data==1){
          this.submitted = true;
          this.display=false;

          this.getAll();
        }
        else {
          console.log(data)
        }
      }
    })


  }




  hideDialog() {
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




  search(event: Event) {
    let value=(event.target as HTMLInputElement).value;
    this.dataSource.filter=value;
  }



  get item(): Contrat {
    return this.service.item ;
  }

  set item(value: Contrat) {
    this.service.item = value;
  }

  get items(): Array<Contrat> {
    return this.service.items;
  }

  set items(value: Array<Contrat>) {
    this.service.items = value;
  }

  editProduct(item: Contrat) {

    alert('pas de champ à modifier ');
  }

  protected readonly console = console;


  public  handlDelete(numContrat:number){
    this.service.delete(numContrat).subscribe({
      next:(data) => {

        if(data==1) this.getAll();
      },
      error:(err) => {
        console.log(err)
      }
    })
  }


}


//
//   public _ok:boolean=false;
//
//   constructor(public _service :ContratService,private router:Router) {
//
//   }
//
//
//   public save() {
//     this.service.save().subscribe({
//       next: (response) => {
//         console.log(response)
//         if (response === -1) {
//         } else if (response === -2) {
//         } else if (response === -3) {
//         } else if (response === 1) {
//           this._ok = true
//           setTimeout(() => {
//             this._ok = false; // Hide the notification after 5 seconds
//           }, 10000);
//
//           this.get();
//         }
//       },
//       error: (err) => {
//         console.log("error::"+err)
//       }
//     });
//   }
//
//
//   public  get(){
//     this._service.getAll().subscribe({
//       next:data=>{
//         this.items=data
//       },
//       error:err => {
//         console.log(err)
//       }
//     })
//   }
//
//   public  delete(numContrat:number){
//     this._service.delete(numContrat).subscribe({
//       next:value => {
//         this.get();
//       },
//       error:err => {
//         console.log(err)
//       }
//     })
//   }
//
//   ngOnInit(): void {
//     this.get();
//   }
//
//
//   // editProp(cin:string) {
//   //   this.router.navigateByUrl("editProp")
//   // }
//
//
//
//
//   get item(): Contrat {
//     return this._service.item;
//   }
//
//
//   set item(value: Contrat) {
//     this._service.item = value;
//   }
//
//
//   get items(): Array<Contrat> {
//     return this._service._items;
//   }
//
//   set items(value: Array<Contrat>) {
//     this._service._items = value;
//   }
//   get service(): ContratService {
//     return this._service;
//   }
//
//   set service(value: ContratService) {
//     this._service = value;
//   }
//
//
//
//   public  update(cin :string):any{
//
//
//
//
//
//     // supprimet() {
//     //   this.item.nom="";
//     //   this.item.prenom="";
//     //   this.item.email="";
//     //   this.item.username="";
//     //   this.item.ribPropAppt="";
//     //   this.item.numTele="",
//     //     this.item.numCompteBkPropApp="",
//     //     this.item.cin=""
//     // }
//
//
//
//
//
//
// // this._service.cinEdit=cin
// //     console.log(this._service.cinEdit)
//     // this.router.navigateByUrl("editProp")
//     // this._service.update(this.item).subscribe(
//     //   {
//     //     next :data=>{
//     //       console.log("mohammed")
//     //       this._ok = true
//     //       setTimeout(() => {
//     //         this._ok = false; // Hide the notification after 5 seconds
//     //       }, 10000);
//     //
//     //       this.get();
//     //     },error:err => {
//     //       console.log(err);
//     //     }
//     //   }
//     // )
//
//
//
//
//
//
//
//
//
//
//
//     // public  getAppartemetsbyCin(cin:String){
//     //   this._appartementService.getAppartemetsCin(cin).subscribe({
//     //     next:data=>{
//     //       // console.log(data)
//     //       this._service._appartemetsByCin=data
//     //       console.log(this._service._appartemetsByCin)
//     //       this.router.navigateByUrl("/listComponent")
//     //
//     //     },
//     //     error:err => {
//     //       console.log(err)
//     //     }
//     //   })
//     // }
//
//   }
//
// }
