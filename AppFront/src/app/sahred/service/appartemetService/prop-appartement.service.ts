import { Injectable } from '@angular/core';
import { PropAppartement } from '../../model/appartemetModel/prop-appartement.model';
import {Appartement} from "../../model/appartemetModel/appartement.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PropAppartementService {


  public _item: PropAppartement = new PropAppartement();
  public _items:Array<PropAppartement>=new Array<PropAppartement>();
  _appartemetsByCin: Array<Appartement>=new Array<Appartement>();

  private _cinPropService! :string;

  public  editPropExiste : PropAppartement=new PropAppartement();

  get cinPropService(): string {
    return this._cinPropService;
  }

  set cinPropService(value: string) {
    this._cinPropService = value;
  }

  constructor(private http: HttpClient) { }

  public save(): Observable<any> {
    return this.http.post<number>("http://localhost:8085/api/propAppartement/", this.item);
  }

  public getAll():Observable<Array<PropAppartement>>{
    return this.http.get<Array<PropAppartement>>("http://localhost:8085/api/propAppartement/");
  }

  public get(cin:string):Observable<PropAppartement>{
    return this.http.get<PropAppartement>(`http://localhost:8085/api/propAppartement/cin/${cin}`);
  }

  public delete(cin:string):Observable<any>{
    return this.http.delete<number>(`http://localhost:8085/api/propAppartement/cin/${cin}`);
  }


  public  update(propritaire:PropAppartement):Observable<any>{
    return this.http.put("http://localhost:8085/api/propAppartement/",propritaire)

  }


  get item(): PropAppartement {
    return this._item;
  }

  set item(value: PropAppartement) {
    this._item = value;
  }

  get items(): Array<PropAppartement> {
    return this._items;
  }

  set items(value: Array<PropAppartement>) {
    this._items = value;
  }


  get appartemetsByCin(): Array<Appartement> {
    return this._appartemetsByCin;
  }

  set appartemetsByCin(value: Array<Appartement>) {
    this._appartemetsByCin = value;
  }
}
