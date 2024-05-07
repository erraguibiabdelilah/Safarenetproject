import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Appartement} from "../../../../sahred/model/appartemetModel/appartement.model";
import {CategoriesAppartement} from "../../../../sahred/model/appartemetModel/categories-appartement.model";
import {PropAppartement} from "../../../../sahred/model/appartemetModel/prop-appartement.model";
import {AppartemetService} from "../../../../sahred/service/appartemetService/appartemet.service";
import {
  CategoriesAppartementService
} from "../../../../sahred/service/appartemetService/categories-appartement.service";
import {PropAppartementService} from "../../../../sahred/service/appartemetService/prop-appartement.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {Reservation} from "../../../../sahred/model/communModel/reservation.model";
import {content} from "html2canvas/dist/types/css/property-descriptors/content";
import {response} from "express";
import {AuthService} from "../../../../security/serviceAuth/auth.service";
import {FileHandle} from "../../../../sahred/model/file-handle.model";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-creat-appartemet',
  templateUrl: './creat-appartemet.component.html',
  styleUrl: './creat-appartemet.component.css'
})
export class CreatAppartemetComponent implements OnInit,AfterViewInit{
  public dataSource!: MatTableDataSource<any>;

  public display:boolean = false;
  public submitted:boolean=false;


  displayImagesByCode: boolean=false;

  public displayedColumns = [
    "id", "code","superficie","adresse","loyerMensuel","ref","photo","libelle","action"
  ];


  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;

  images:any;

  selectedAppartementItem: Appartement ={
    "id":0,
    "code":"",
    "superficie":0,
    "adresse":"",
    "loyerMensuel":0,
    reservationDto:{},
    images:[],
    categoriesAppartementDto : {
      id:0,
      libelle:""
    },
    propAppartemenetDto: {
      nom : "",
      prenom : "",
      numTele : "",
      email : "",
      ribPropAppt : "",
      numCompteBkPropApp : "",
      cin : "",
      username : "",
      password:""
    }
  };

  isEdit :boolean=false;
  isCreate :boolean=false;


  constructor(private sanitizer:DomSanitizer, protected appartemetService:AppartemetService, private categoriesAppartementService:CategoriesAppartementService, protected authService:AuthService) {
  }

  ngOnInit(): void {
    this.viderItemSelected();
    this.getAll()
    console.log(this.authService.dataUtilisateur)
    this.appartemetService.getImagesByProduitRef("1212");
  }


  creatCategorie() {
    this.isCreate=true
    this.isEdit=false;
    this.viderItemSelected();
    this.display = true;
  }

  fileDropped(fileHandle: FileHandle) {
    this.appartemetService.item.images.push(fileHandle);
  }

  prepareFormData(apartemet:Appartement):FormData{
    const  formData=new FormData();
    formData.append(
      'apartment'
      , new Blob(
        [JSON.stringify(apartemet)],
        {type:'application/json'}
      ));

    for (var i=0;i<apartemet.images.length;i++){
      formData.append(
        'imageFile',
        apartemet.images[i].file,
        apartemet.images[i].file.name
      );
    }
    console.log("mohammed")
    console.log(formData)
    return formData;
  }

  saveObject() {
    console.log(this.authService.dataUtilisateur)
    this.item.propAppartemenetDto.cin=this.authService.dataUtilisateur.cin
    console.log(this.item.propAppartemenetDto.cin)
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


  editCategorie(element:Appartement) {
    this.isCreate=false;
    this.isEdit=true
    this.selectedAppartementItem = Object.assign({}, element);
    this.display = true;
  }


  updateObject() {
    console.log(this.selectedAppartementItem)
    console.log(this.item)
    this.appartemetService.update(this.item).subscribe({
      next:data=>{
        if(data==1){
          this.getAll();
          this.display=false;
          console.log(data)
        }else {
         console.log(data)
        }

      },
      error:err => {
        console.log(err)
      }
    })

  }
/***************************************************************************************************/
  oneFileSelected($event: Event) {
    // @ts-ignore
    if($event.target.files){
      // @ts-ignore
      const  file=$event.target.files[0];

      console.log(file);
      const fileHandle:FileHandle={
        file:file,
        url: this.sanitizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(file)
        )
      }
      console.log(fileHandle)
      console.log(this.appartemetService.item.images)
      this.appartemetService.item.images.push(fileHandle);
    }
  }



  removeImages(i:number) {
    this.appartemetService.item.images.splice(i,1);
  }

  /***************************************************************************************************/

  search(event: Event) {
    let value=(event.target as HTMLInputElement).value;
    this.dataSource.filter=value
  }

  //crud

  //1-save
  public save() {
    const  productFormData=this.prepareFormData(this.appartemetService.item);
    console.log("appartemet item :")
    console.log(this.appartemetService.item)
    console.log("productFormData  :")
    console.log(productFormData)
    this.appartemetService.save(productFormData).subscribe({
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
    this.appartemetService.getAll().subscribe({
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


  public  delete(code:String){
    this.appartemetService.delete(code).subscribe({
      next:() => {
        console.log()
        this.getAll();
      },
      error:(err: any) => {
        console.log(err)
      }
    })
  }

  public  categorits : CategoriesAppartement[]=[]

  public  categoriesString: string[]=[]

  public selectedCategory: string="";

  public  getCategoriesLibelle(){
    this.categoriesAppartementService.getAll().subscribe(
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

  public  update():any{
    return this.appartemetService.update(this.item).subscribe({
      next:()=>{
        this.getAll();
      },
      error:()=>{
      }
    })
  }

  viderItemSelected(){
    this.selectedAppartementItem={
      "id":0,
      "code":"",
      "superficie":0,
      "adresse":"",
      "loyerMensuel":0,
      reservationDto:{},
      images:[],
      categoriesAppartementDto : {
        id:0,
        libelle:""
      },
      propAppartemenetDto: {
        nom : "",
        prenom : "",
        numTele : "",
        email : "",
        ribPropAppt : "",
        numCompteBkPropApp : "",
        cin : "",
        username : "",
        password:""
      }
    }
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

  ngAfterViewInit(): void {
    // this.dataSource.paginator = this.paginator;
    // this.dataSource.sort=this.sort;
  }



  //
  // public _ok:boolean=false;
  //
  // public  propUpdate!:Appartement;
  //
  // public  categorits : CategoriesAppartement[]=[]
  //
  // public  categoriesString: string[]=[]
  //
  // public selectedCategory: string="";
  //
  // public  propAppartements! :PropAppartement[]
  //
  // public  propString : string[]=[]
  // public  selectedProp :string=""
  // constructor(public appartemetService :AppartemetService,public categorieService:CategoriesAppartementService,public  propAppartement:PropAppartementService) {
  // }
  //
  // public save() {
  //   this.item.categoriesAppartementDto.libelle=this.selectedCategory
  //   this.item.propAppartemenetDto.cin=this.selectedProp
  //   this.service.save().subscribe({
  //
  //     next: (response: number) => {
  //
  //       console.log(response)
  //       if (response === -1) {
  //
  //       } else if (response === -2) {
  //         console.log("mohammed l3z!!")
  //       } else if (response === -3) {
  //         // Traitement pour le cas où l'enregistrement a échoué avec le code -3
  //       } else if (response === 1) {
  //
  //         this._ok = true
  //         setTimeout(() => {
  //           this._ok = false; // Hide the notification after 5 seconds
  //         }, 10000);
  //
  //         this.getAll();
  //
  //       }
  //     },
  //     error: () => {
  //       // Gérer les erreurs
  //     }
  //   });
  // }
  //
  //
  // public  getAll(){
  //   this.appartemetService.getAll().subscribe({
  //     next:data=>{
  //       this.items=data
  //     },
  //     error:err => {
  //       console.log(err)
  //     }
  //   })
  // }
  //
  //
  //
  // public  getCategoriesLibelle(){
  //   this.categorieService.getAll().subscribe(
  //     {
  //       next:data=>{
  //         this.categorits=data
  //         this.categorits.map(c=>{
  //           this.categoriesString.push(c.libelle.toString())
  //         })
  //       }
  //     }
  //   )
  // }
  //
  // public  getPropCin(){
  //   this.propAppartement.getAll().subscribe(
  //     {
  //       next:data=>{
  //         this.propAppartements=data
  //         this.propAppartements.map(c=>{
  //           this.propString.push(c.cin.toString())
  //         })
  //       }
  //     }
  //   )
  // }
  //
  //
  // public  delete(cin:string){
  //   this.appartemetService.delete(cin).subscribe({
  //     next:value => {
  //       this.getAll();
  //     },
  //     error:err => {
  //       console.log(err)
  //     }
  //   })
  // }
  //
  //
  // public  update():any{
  //   return this.appartemetService.update(this.propUpdate).subscribe({
  //     next:()=>{
  //       this.getAll();
  //     },
  //     error:()=>{
  //
  //     }
  //
  //   })
  //
  // }
  //
  //
  //
  // get item(): Appartement {
  //   return this.appartemetService.item;
  // }
  //
  // set item(value: Appartement) {
  //   this.appartemetService.item = value;
  // }
  //
  // get items(): Array<Appartement> {
  //   return this.appartemetService._items;
  // }
  //
  // set items(value: Array<Appartement>) {
  //   this.appartemetService._items = value;
  // }
  //
  //
  // get service(): AppartemetService {
  //   return this.appartemetService;
  // }
  //
  // set service(value: AppartemetService) {
  //   this.appartemetService = value;
  // }
  //
  // ngOnInit(): void {
  //   console.log(this.items.map(value => console.log(value)))
  //   this.getAll();
  //   this.getCategoriesLibelle();
  //   this.getPropCin();
  // }

  photoByCode(code:any) {
    this.appartemetService.getImagesByProduitRef(code).subscribe(
      {
        next:data=>{
        this.images=data;
        this.displayImagesByCode=true;
        console.log(this.images)
        }
      }
    )

  }


  getImageData(photo:any) {

    // // return 'data:image/jpeg;base64,' + image1.picByte;
    // console.log('data:'+image1.type+';base64,' + image1.picByte)
    return 'data:'+photo.type+';base64,' + photo.picByte;
  }

}
