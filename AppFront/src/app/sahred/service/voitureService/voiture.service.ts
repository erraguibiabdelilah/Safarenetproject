import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Voiture} from "../../model/voitureModel/voiture.model";
import {CategorieVoiture} from "../../model/voitureModel/categorie-voiture.model";

@Injectable({
  providedIn: 'root'
})
export class VoitureService {
private _item:Voiture=new Voiture();
private _items:Array<Voiture>=new Array<Voiture>();
private url="http://localhost:8085/api/safarent/manager/voiture/"

  constructor(private http:HttpClient) { }

  public save(): Observable<number> {
    return this.http.post<number>(this.url, this._item);
  }

  public getAll():Observable<Array<Voiture>>{
    return this.http.get<Array<Voiture>>(this.url);
  }

  public delete(matricule:String):Observable<any>{
    return this.http.delete<number>(`${this.url}matricule/${matricule}`);
  }

  public  update(voiture:Voiture):Observable<any>{
    return this.http.put(this.url,voiture)
  }


  get item(): Voiture {
    return this._item;
  }

  set item(value: Voiture) {
    this._item = value;
  }

  get items(): Array<Voiture> {
    return this._items;
  }

  set items(value: Array<Voiture>) {
    this._items = value;
  }
}
