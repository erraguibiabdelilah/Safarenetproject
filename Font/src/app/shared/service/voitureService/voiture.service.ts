import {PropAppartement} from "../../model/appartementModel/propAppartemenet.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Voiture} from "../../model/voitureModel/Voiture.model";
import {Injectable} from "@angular/core";
@Injectable({
  providedIn: 'root'
})

export class VoitureService{


  // @ts-ignore
  private _item: Voiture =new Voiture();
  private _items:Array<Voiture>=new Array<Voiture>();
  private  url="http://localhost:8081/api/safarent/manager/voiture/"



  constructor(private http: HttpClient) { }

public save(): Observable<number> {
    return this.http.post<number>(this.url, this.item);
  }

public get():Observable<Array<Voiture>>{
    return this.http.get<Array<Voiture>>(this.url);
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
