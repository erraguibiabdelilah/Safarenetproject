import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {VoitureService} from "../../../../sahred/service/voitureService/voiture.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {CategorieVoitureService} from "../../../../sahred/service/voitureService/categorie-voiture.service";
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {CategorieVoiture} from "../../../../sahred/model/voitureModel/categorie-voiture.model";
import {AgenceLocation} from "../../../../sahred/model/voitureModel/agence-location.model";
import {Voiture} from "../../../../sahred/model/voitureModel/voiture.model";
import {AgenceLocationService} from "../../../../sahred/service/voitureService/agence-location.service";

@Component({
  selector: 'app-creat-voiture',
  templateUrl: './creat-voiture.component.html',
  styleUrl: './creat-voiture.component.css'
})
export class CreatVoitureComponent  implements OnInit, AfterViewInit {

  public dataSource!: MatTableDataSource<any>;
  public display:boolean = false;
  public submitted:boolean=false;
  public categorie:Array<CategorieVoiture>=new Array<CategorieVoiture>();
  public agencesLocations:Array<AgenceLocation>=new Array<AgenceLocation>();
  public ListeColum = [
    "couleur","photo","nbrPlace","matricule","kiloMetrage","boitevitesse","annee","ville","dateMisecirculation"
    ,"dateAssurance","sateVisitetechnique","nomModele","prix","puissance","Carburant","categorie","agenceLocation","action"
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;


  constructor(private service:VoitureService,private categorieService:CategorieVoitureService,private agenceService :AgenceLocationService) {

  }



  ngOnInit(): void {
    this.getAll();

    console.log(this.dataSource)
    this.getAllCategorie();
    this.getAllAgence();
    console.log(this.categorie)
  this.item.categorie=new CategorieVoiture();
  this.item.agenceLocation=new AgenceLocation();
  }

getAllCategorie(){
    this.categorieService.getAll().subscribe({
      next:(data)=>{this.categorie=data}})
}

  getAllAgence(){
    this.agenceService.getAll().subscribe({next:(data)=>{this.agencesLocations=data}})
  }


  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort=this.sort;
  }


  public getAll(){
    this.service.getAll().subscribe({
      next:(data)=>{

        this.items=data;
        this.dataSource = new MatTableDataSource<any>(this.items);

        if(data.length!=0){console.log(data); console.log(this.items)}
      },
      error:(err)=>{
        console.log('verifier getAll categorie Voiture');
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
          alert('ok')
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



  get item(): Voiture {
    return this.service.item ;
  }

  set item(value: Voiture) {
    this.service.item = value;
  }

  get items(): Array<Voiture> {
    return this.service.items;
  }

  set items(value: Array<Voiture>) {
    this.service.items = value;
  }

  editProduct(item: Voiture) {
    this.service.update(item).subscribe({
      next:(data)=>{
        if(data==1){
          alert("updated")
        }else{
          console.log(data);
        }
      }
    })
  }


  public  handlDelete(matricule:string){
    this.service.delete(matricule).subscribe({
      next:(data) => {
        this.getAll();
        if(data==1) alert('deleted')
      },
      error:(err) => {
        console.log(err)
      }
    })
  }

}
