import {Inject, Injectable, PLATFORM_ID} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {jwtDecode} from "jwt-decode";
import {Router} from "@angular/router";
import {AppUser} from "../bean/app-user.model";
import {isPlatformBrowser} from "@angular/common";
import {Client} from "../../sahred/model/communModel/client.model";
import {PropAppartement} from "../../sahred/model/appartemetModel/prop-appartement.model";
import {AgenceLocation} from "../../sahred/model/voitureModel/agence-location.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isAuthService : boolean =false;
  roles : any;
  username : any;
  accessToken! : any ;

  accessTokenEz! : any ;
  userApp :AppUser=new AppUser();

  client:Client=new Client();

  propAppartement:PropAppartement=new PropAppartement();

  agenceLocation:AgenceLocation=new AgenceLocation();



  // refrechToken! :any;
  constructor(private http: HttpClient,private router:Router,@Inject(PLATFORM_ID) private platformId: Object) { }

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
    this.accessTokenEz=this.accessToken

    // this.refrechToken=data['refreshToken'];

    // @ts-ignore
    let decodejwt = jwtDecode(this.accessToken) as { sub: string, authority: string };
    this.username=decodejwt.sub;
    this.roles=decodejwt.authority
    console.log(this.roles)

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
    if (isPlatformBrowser(this.platformId)) {
      let tokenAccess=window.localStorage.getItem("jwt-token-access");
      // let tokenRefrech=window.localStorage.getItem("jwt-token-ref");
      console.log("token localStorage")
      if(tokenAccess ){
        this.loadProfile({"accessToken":tokenAccess});
        this.router.navigateByUrl("/admin")

      }
    }
  }

  // loadJwtTokenFromLocalStrage() {
  //   let tokenAccess=window.localStorage.getItem("jwt-token-access");
  //   // let tokenRefrech=window.localStorage.getItem("jwt-token-ref");
  //   console.log("token localStorage")
  //   if(tokenAccess ){
  //     this.loadProfile({"accessToken":tokenAccess});
  //     this.router.navigateByUrl("/admin")
  //
  //   }
  // }

  creeCompte1(client:Client){
    return  this.http.post<number>("http://localhost:8085/api/client/",client)
  }

  creeCompte2(propAppartement:PropAppartement){
    return  this.http.post<number>("http://localhost:8085/api/propAppartement/",propAppartement)
  }

  creeCompte3(agenceLocation:AgenceLocation){
    return  this.http.post<number>("http://localhost:8085/api/agenceLocation/",agenceLocation)
  }




  viderClient(){
    this.client.cin="";
    this.client.prenom="";
    this.client.nom="";
    this.client.numTeleClient="";
    this.client.username_Client="";
    this.client.password_Client="";
    this.client.email_Client="";
  }

  viderProp(){
    this.propAppartement.cin="";
    this.propAppartement.prenom="";
    this.propAppartement.nom="";
    this.propAppartement.numTele="";
    this.propAppartement.email="";
    this.propAppartement.ribPropAppt="";
    this.propAppartement.numCompteBkPropApp="";
    this.propAppartement.username="";
    this.propAppartement.password="";
  }

  viderAgence(){
    this.agenceLocation.iceAgLoc=0;
    this.agenceLocation.raisonSocialAg="";
    this.agenceLocation.adresse="";
    this.agenceLocation.numTelephone=0;
    this.agenceLocation.numCompteBkAgLoc=0;
    this.agenceLocation.ribAgenceLoc=0;
    this.agenceLocation.usernameAgenceLoc="";
    this.agenceLocation.password="";
    this.agenceLocation.RCAgLoc=0;
  }

}
