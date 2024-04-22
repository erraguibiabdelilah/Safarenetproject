import {Categorie} from "../../model/voitureModel/Categorie.model";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class CategorieService{
  // @ts-ignore
  private _item:Categorie=new Categorie();
  private _items:Array<Categorie>=new Array<Categorie>();
  private  url="http://localhost:8081/api/safarent/manager/categorieVoiture/"

  constructor(private http :HttpClient) {

  }

public save():Observable<number>{
    return this.http.post<number>(this.url,this.item);

}

public getAll():Observable<Array<Categorie>>{
    return this.http.get<Array<Categorie>>(this.url);
}


  get item(): Categorie {
    return this._item;
  }

  set item(value: Categorie) {
    this._item = value;
  }

  get items(): Array<Categorie> {
    return this._items;
  }

  set items(value: Array<Categorie>) {
    this._items = value;
  }


}
