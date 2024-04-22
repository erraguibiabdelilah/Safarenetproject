import {Injectable, OnInit} from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import {PropAppartement} from "../model/appartementModel/propAppartemenet.model";

@Injectable({
  providedIn: 'root'
})
export class PropAppartementService {
  get items(): Array<PropAppartement> {
    return this._items;
  }

  set items(value: Array<PropAppartement>) {
    this._items = value;
  }


  _item: PropAppartement = new PropAppartement();
  _items:Array<PropAppartement>=new Array<PropAppartement>();

  get item(): PropAppartement {
    return this._item;
  }

  set item(value: PropAppartement) {
    this._item = value;
  }

  constructor(private http: HttpClient) { }

  public save(): Observable<any> {
    return this.http.post<number>("http://localhost:8081/api/propAppartement/", this.item);
  }

  public get():Observable<Array<PropAppartement>>{
    // @ts-ignore
    return this.http.get<Array<PropAppartement>>("http://localhost:8081/api/propAppartement/");
  }

  public delete(cin:string):Observable<any>{
    // @ts-ignore
    return this.http.delete<number>(`http://localhost:8081/api/propAppartement/cin/${cin}`);
  }


  public  update(propritaire:PropAppartement):Observable<any>{
    return this.http.put("http://localhost:8081/api/propAppartement/cin/",propritaire)

  }
}
