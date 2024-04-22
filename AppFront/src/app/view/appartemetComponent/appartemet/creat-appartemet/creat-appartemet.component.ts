import { Component } from '@angular/core';
import {Appartemet} from "../../../../sahred/model/appartemetModel/appartemet.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Component({
  selector: 'app-creat-appartemet',
  templateUrl: './creat-appartemet.component.html',
  styleUrl: './creat-appartemet.component.css'
})
export class CreatAppartemetComponent {


  public codeAppartemetService! :string;

  public  editAppartemetExiste : Appartemet=new Appartemet();


  public _item: Appartemet = new Appartemet();
  public _items:Array<Appartemet>=new Array<Appartemet>();



  constructor(private http: HttpClient) {

  }

  public save(): Observable<any> {
    return this.http.post<number>("http://localhost:8081/api/appartement/", this.item);
  }

  public getAll():Observable<Array<Appartemet>>{
    return this.http.get<Array<Appartemet>>("http://localhost:8081/api/appartement/");
  }

  public delete(code:String):Observable<any>{
    return this.http.delete<number>(`http://localhost:8081/api/appartement/code/${code}`);
  }


  public  getAppartemetsbyLibelle(libelle:String):Observable<any>{
    return this.http.get(`http://localhost:8081/api/appartement/listAppartementCategories/${libelle}`);
  }


  public  getAppartemetsCin(cin:String):Observable<any>{
    return this.http.get(`http://localhost:8081/api/appartement/listAppartementCin/${cin}`);
  }


  public  update(propritaire:Appartemet):Observable<any>{
    return this.http.put("http://localhost:8081/api/appartement/",propritaire)

  }


  get items(): Array<Appartemet> {
    return this._items;
  }

  set items(value: Array<Appartemet>) {
    this._items = value;
  }

  get item(): Appartemet {
    return this._item;
  }

  set item(value: Appartemet) {
    this._item = value;
  }


  get(code: string):Observable<Appartemet> {

    return this.http.get<Appartemet>(`http://localhost:8081/api/appartement/code/${code}`);

  }

}
