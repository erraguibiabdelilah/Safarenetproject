import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Location} from "../../model/communModel/location.model";

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  public _item: Location = new Location();
  public _items:Array<Location>=new Array<Location>();

  constructor(private http: HttpClient) {}
  public save(): Observable<any> {
    return this.http.post<number>("http://localhost:8085/api/location/", this.item);
  }

  public getAll():Observable<Array<Location>>{
    return this.http.get<Array<Location>>("http://localhost:8085/api/location/");
  }

  public delete(ref:String):Observable<any>{
    return this.http.delete<number>(`http://localhost:8085/api/location/ref/${ref}`);
  }

  public  update(propritaire:Location):Observable<any>{
    return this.http.put("http://localhost:8085/api/location/",propritaire)

  }


  get items(): Array<Location> {
    return this._items;
  }

  set items(value: Array<Location>) {
    this._items = value;
  }

  get item(): Location {
    return this._item;
  }

  set item(value: Location) {
    this._item = value;
  }


  get(ref: string):Observable<Location> {
    return this.http.get<Location>(`http://localhost:8085/api/location/ref/${ref}`);

  }
}
