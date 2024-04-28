import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../security/serviceAuth/auth.service";
import {RedirectService} from "../../sahred/service/LayoutService/RedirectService.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public authService: AuthService,private router: Router, private redirectService:RedirectService) { }

  ngOnInit(): void {
  }

  handleLogout() {
    this.authService.logout();
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

}
