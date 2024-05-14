import {AfterViewInit, Component, NgModule, OnInit, ViewChild} from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import html2canvas from "html2canvas";
import jsPDF from 'jspdf';
import {Voiture} from "../../../../sahred/model/voitureModel/voiture.model";
import {VoitureService} from "../../../../sahred/service/voitureService/voiture.service";
import {CategorieVoiture} from "../../../../sahred/model/voitureModel/categorie-voiture.model";
import {CategorieVoitureService} from "../../../../sahred/service/voitureService/categorie-voiture.service";
import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
import {content} from "html2canvas/dist/types/css/property-descriptors/content";


@Component({
  selector: 'app-creat-categorie-voiture',
  templateUrl: './creat-categorie-voiture.component.html',
  styleUrl: './creat-categorie-voiture.component.css'
})
export class CreatCategorieVoitureComponent implements OnInit, AfterViewInit {
  public isEdit: boolean=false;
  public isCreat: boolean=false;


public dataSource!: MatTableDataSource<any>;
public display:boolean = false;
public submitted:boolean=false;


public ListeColum = [
    "libelle","action"
  ];

@ViewChild(MatPaginator) paginator!: MatPaginator;
@ViewChild(MatSort) sort!:MatSort;

  constructor(private service:CategorieVoitureService) {
  }



  ngOnInit(): void {
    this.getAll();

  console.log(this.dataSource)
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
    this.isCreat=true;
    this.isEdit=false
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



  get item(): CategorieVoiture {
    return this.service.item ;
  }

  set item(value: CategorieVoiture) {
    this.service.item = value;
  }

  get items(): Array<CategorieVoiture> {
    return this.service.items;
  }

  set items(value: Array<CategorieVoiture>) {
    this.service.items = value;
  }

  selectedCategorieItem: CategorieVoiture ={
    "libelle":""
  };

  editCategorie(element:CategorieVoiture) {
    console.log(element)
    console.log(this.selectedCategorieItem)
    this.isCreat=false;
    this.isEdit=true
    this.selectedCategorieItem = Object.assign({}, element);
    this.display = true;

  }


  protected readonly console = console;


  public  handlDelete(libelle:string){
    this.service.delete(libelle).subscribe({
      next:(data) => {
        this.getAll();
        if(data==1) alert('deleted')
      },
      error:(err) => {
        console.log(err)
      }
    })
  }


  Editbject() {
    let data={
      "libelle": this.selectedCategorieItem.libelle,
      "libelleNew": this.item.libelle
    }
    console.log(data);
    this.service.update(data).subscribe({
      next:data=>{
        console.log(data)
        this.display=false;
        this.getAll();
      },
      error:err => {
        console.log(err)
      }
    })
  }
}

