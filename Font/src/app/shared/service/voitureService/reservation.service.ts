import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {Reservation} from "../../model/voitureModel/reservation.model";
@Injectable({
  providedIn: 'root'
})

export class ReservationService{


  // @ts-ignore
  private _item: Reservation =new Reservation();
  private _items:Array<Reservation>=new Array<Reservation>();
  private  url="http://localhost:8081/api/safarent/manager/reservation/"



  constructor(private http: HttpClient) { }

  public save(): Observable<number> {
    return this.http.post<number>(this.url, this.item);
  }

  public get():Observable<Array<Reservation>>{
    return this.http.get<Array<Reservation>>(this.url);
  }



  public  update(reservation:Reservation):Observable<number>{
    return this.http.put<number>(this.url,reservation)

  }


  get item(): Reservation {
    return this._item;
  }

  set item(value: Reservation) {
    this._item = value;
  }

  get items(): Array<Reservation> {
    return this._items;
  }

  set items(value: Array<Reservation>) {
    this._items = value;
  }
}
