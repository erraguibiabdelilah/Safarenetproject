import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Appartement} from "../../model/appartemetModel/appartement.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppartemetService {


  imagesUtilisateur:any;
  public codeAppartemetService! :string;

  public  editAppartemetExiste : Appartement=new Appartement();


  public _item: Appartement = new Appartement();
  public _items:Array<Appartement>=new Array<Appartement>();



  constructor(private http: HttpClient) {

  }

  public save(appadtemetFormData: FormData): Observable<any> {
    return this.http.post<number>("http://localhost:8085/api/appartement/", appadtemetFormData);
  }

  public getAll():Observable<Array<Appartement>>{
    return this.http.get<Array<Appartement>>("http://localhost:8085/api/appartement/");
  }

  public delete(code:String):Observable<any>{
    return this.http.delete<number>(`http://localhost:8085/api/appartement/code/${code}`);
  }


  public  getAppartemetsbyLibelle(libelle:String):Observable<any>{
    return this.http.get(`http://localhost:8085/api/appartement/listAppartementCategories/${libelle}`);
  }


  public  getAppartemetsCin(cin:String):Observable<any>{
    return this.http.get(`http://localhost:8085/api/appartement/listAppartementCin/${cin}`);
  }


  public  update(propritaire:Appartement):Observable<any>{
    return this.http.put("http://localhost:8085/api/appartement/",propritaire)

  }

  // public getImagesByProduitRef(code:string):any{
  //
  //   this.http.get(`http://localhost:8085/api/appartement/images/${code}`).subscribe(
  //     {
  //       next:data=>{
  //         this.imagesUtilisateur=data
  //         console.log(this.imagesUtilisateur);
  //       },
  //       error:err => {
  //         console.log(err);
  //       }
  //     }
  //   );
  //
  // }


  public getImagesByProduitRef(code:string):Observable<any>{
   return  this.http.get<any>(`http://localhost:8085/api/appartement/images/${code}`);

  }


  get items(): Array<Appartement> {
    return this._items;
  }

  set items(value: Array<Appartement>) {
    this._items = value;
  }

  get item(): Appartement {
    return this._item;
  }

  set item(value: Appartement) {
    this._item = value;
  }


  get(code: string):Observable<Appartement> {
    return this.http.get<Appartement>(`http://localhost:8085/api/appartement/code/${code}`);

  }
}
