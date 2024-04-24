import { Injectable } from '@angular/core';
import {PropAppartement} from "../../model/appartemetModel/prop-appartement.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AgenceLocation} from "../../model/voitureModel/agence-location.model";

@Injectable({
  providedIn: 'root'
})
export class AgenceLocationService {


  public _item: AgenceLocation = new AgenceLocation();
  public _items:Array<AgenceLocation>=new Array<AgenceLocation>();
  constructor(private http: HttpClient) { }


  get item(): AgenceLocation {
    return this._item;
  }

  set item(value: AgenceLocation) {
    this._item = value;
  }

  get items(): Array<AgenceLocation> {
    return this._items;
  }

  set items(value: Array<AgenceLocation>) {
    this._items = value;
  }

  creeCompte(iceAgLoc:any,username: any, password: any):Observable<any> {
    this.item.iceAgLoc=iceAgLoc;
    this.item.usernameAgenceLoc=username;
    this.item.password=password;
    console.log(this.item)
    return  this.http.post<any>("http://localhost:8085/api/agenceLocation/", this.item)
  }
}
