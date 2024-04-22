import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {jwtDecode} from "jwt-decode";
import {Router} from "@angular/router";
import {AppUser} from "../bean/app-user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isAuthService : boolean =false;
  roles : any;
  username : any;
  accessToken! : any ;

  userApp :AppUser=new AppUser();
  // refrechToken! :any;
  constructor(private http: HttpClient,private router:Router) { }

  login(username: string, password: string): Observable<any> {
    const options = {
      headers: new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded")
    }

    const params = new HttpParams()
      .set('username', username)
      .set('password', password);

    return this.http.post('http://localhost:8085/login', params, options)
  }

  loadProfile(data: any) {
    this.isAuthService=true
    this.accessToken=data['accessToken'];
    console.log(this.accessToken)
    // this.refrechToken=data['refreshToken'];

    // @ts-ignore
    let decodejwt = jwtDecode(this.accessToken) as { sub: string, authority: string };
    console.log("mohammed")
    console.log(decodejwt)
    console.log("mohammed")
    this.username=decodejwt.sub;
    this.roles=decodejwt.authority

    window.localStorage.setItem("jwt-token-access",this.accessToken);
    // window.localStorage.setItem("jwt-token-ref",this.refrechToken);
  }

  logout() {
    this.isAuthService=false;
    this.accessToken=undefined;
    this.username=undefined;
    this.roles=undefined;
    window.localStorage.removeItem("jwt-token-access")

    this.router.navigateByUrl("/login")
  }

  loadJwtTokenFromLocalStrage() {
    let tokenAccess=window.localStorage.getItem("jwt-token-access");
    // let tokenRefrech=window.localStorage.getItem("jwt-token-ref");
    console.log("token localStorage")
    if(tokenAccess ){
      this.loadProfile({"accessToken":tokenAccess});
      this.router.navigateByUrl("/admin/customers")

    }
  }

  creeCompte(username: any, password: any) {
    this.userApp.username=username;
    this.userApp.password=password;
    console.log(this.userApp)
    return  this.http.post<AppUser>("http://localhost:8085/user",this.userApp)
  }
}
