import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../security/serviceAuth/auth.service";
import {RedirectService} from "../../sahred/service/LayoutService/RedirectService.service";
import {TranslateService} from "@ngx-translate/core";
import {AgenceAppartementService} from "../../sahred/service/appartemetService/agence-appartement.service";
import {AgenceLocation} from "../../sahred/model/voitureModel/agence-location.model";
import {AgenceLocationService} from "../../sahred/service/voitureService/agence-location.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  selectedLanguage: string='English';
  logo:any;
  isMenuToggle:boolean=false;
  roleUrl!:string;
  constructor(private agenceLocationService:AgenceLocationService,private propAppartementService :AgenceAppartementService ,public authService: AuthService,private router: Router, private redirectService:RedirectService,private translateService:TranslateService) {
    this.translateService.setDefaultLang('en');

  }


  // logo  async pour que logo est replir await netsna data
  async ngOnInit(): Promise<void> {
    if (this.authService.isAuthService && this.authService.roles.includes("MANAGER-APT")) {
      try {
        const logos = await this.propAppartementService.getImagesByIceAgApp(this.authService.username).toPromise();
        this.logo = logos[0];
      } catch (err) {
        console.log(err);
      }
    }
    else if(this.authService.isAuthService && this.authService.roles.includes("MANAGER-VOI")){
      try {
        const logos = await this.agenceLocationService.getImagesByIceAgLoc(this.authService.username).toPromise();
        this.logo = logos[0];
      } catch (err) {
        console.log(err);
      }

    }
  }



  nameUrlROle(url:string){
    if(this.authService.roles.includes('MANAGER-VOI')){
      // this.roleUrl="agenceLocation";
      this.router.navigateByUrl(`/agenceLocation/${url}`)
    }
    if(this.authService.roles.includes('MANAGER-APT')){
      // this.roleUrl="propreAppartement"
      this.router.navigateByUrl(`/propreAppartement/${url}`)
    }
  }
  SwitchLanguage(lang:string) {
    this.translateService.use(lang);
    this.selectedLanguage = lang === 'en' ? 'English' : 'Français';
  }
  handleLogout() {
    this.authService.logout();
    this.isMenuToggle=false;
  }



  onMessageClick(): void {
    if (!this.authService.isAuthService) {
      this.redirectService.setRedirectUrl('/message');
    } else {
      //logique si le messagerie n'est pas vide
      this.router.navigateByUrl('/videMessage')
    }
  }

  onNotificationClick(): void {
    if(this.authService.isAuthService)
      this.router.navigateByUrl('/videNotification')
    else
      this.router.navigateByUrl('/notification')
    //logique si la boite de notifaiaction n'est pas vide

  }


  toggleMenu() {
    console.log(this.isMenuToggle)
    this.isMenuToggle=!this.isMenuToggle;
  }

  toggleMenuColose() {
    this.isMenuToggle=false;
  }



  LogoByIceAgApp(iceAgApp:any) {
    this.propAppartementService.getImagesByIceAgApp(iceAgApp).subscribe(
      {
        next:data=>{
         this.logo=data;
        }
      }
    )
  }

  // le but hewa behala url deyal photo lijate men base donner
  getImageData(photo:any) {
    return 'data:'+photo.type+';base64,' + photo.picByte;
  }

}
