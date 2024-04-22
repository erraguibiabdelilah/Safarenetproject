import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CategoriesAppartement} from "../model/appartementModel/categories-appartement.model";

@Injectable({
  providedIn: 'root'
})
export class CategoriesAppartementService {
  get items(): Array<CategoriesAppartement> {
    return this._items;
  }

  set items(value: Array<CategoriesAppartement>) {
    this._items = value;
  }


  _item: CategoriesAppartement = new CategoriesAppartement();
  _items:Array<CategoriesAppartement>=new Array<CategoriesAppartement>();

  get item(): CategoriesAppartement {
    return this._item;
  }

  set item(value: CategoriesAppartement) {
    this._item = value;
  }

  constructor(private http: HttpClient) { }

  public save(): Observable<number> {
    return this.http.post<number>("http://localhost:8081/api/categoriesAppartemen/", this.item);
  }

  public get():Observable<Array<CategoriesAppartement>>{
    // @ts-ignore
    return this.http.get<Array<CategoriesAppartement>>("http://localhost:8081/api/categoriesAppartemen/");
  }

  public delete(libelle:string):Observable<any>{
    // @ts-ignore
    return this.http.delete<number>(`http://localhost:8081/api/categoriesAppartemen/libelle/${libelle}`);
  }


  public  update(propritaire:CategoriesAppartement):Observable<any>{
    return this.http.put("http://localhost:8081/api/categoriesAppartemen/libelle/",propritaire)

  }
}
