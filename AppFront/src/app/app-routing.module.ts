import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {
  CreatAppartemetComponent
} from "./view/appartemetComponent/appartemet/creat-appartemet/creat-appartemet.component";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {
  CreatCategoriesAppartementComponent
} from "./view/appartemetComponent/categoriesAppartement/creat-categories-appartement/creat-categories-appartement.component";
import {
  CreatPropAppartementComponent
} from "./view/appartemetComponent/propAppartement/creat-prop-appartement/creat-prop-appartement.component";
import {ListAppartemetComponent} from "./view/appartemetComponent/appartemet/list-appartemet/list-appartemet.component";
import {AuthenticationGuard} from "./security/guards/authentication.guard";
import {AuthorizationGuard} from "./security/guards/authorization.guard";
import {SignInMessageComponent} from "./layout/sign-in-message/sign-in-message.component";
import {SignInNotificationComponent} from "./layout/sign-in-notification/sign-in-notification.component";
import {HomeComponent} from "./layout/home/home.component";
import {NotFoundPageComponent} from "./layout/not-found-page/not-found-page.component";
import {VideMessageComponent} from "./layout/vide-message/vide-message.component";
import {VideNotificationComponent} from "./layout/vide-notification/vide-notification.component";
import {ListVoitureComponent} from "./view/voitureComponent/voiture/list-voiture/list-voiture.component";
import {
  CreatCategorieVoitureComponent
} from "./view/voitureComponent/categorieVoiture/creat-categorie-voiture/creat-categorie-voiture.component";
import {CreatContratComponent} from "./view/communComponent/contrat/creat-contrat/creat-contrat.component";
import {CreatFactureComponent} from "./view/communComponent/facture/creat-facture/creat-facture.component";
import {CreatLocationComponent} from "./view/communComponent/location/creat-location/creat-location.component";
import {LoginComponent} from "./security/login/login.component";
import {ProfileComponent} from "./layout/profile/profile/profile.component";
import {authGuard} from "./layout/navbar/garde/garde";
import {ProfileEzComponent} from "./view/appartemetComponent/profile-ez/profile-ez.component";

const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path :"login", component : LoginComponent},
  { path :"", redirectTo:"/home",pathMatch:"full"},
  { path: "message", component: SignInMessageComponent },
  { path: "notification", component: SignInNotificationComponent },
  { path: "videMessage", component: VideMessageComponent ,canActivate:[authGuard]},
  { path: "videNotification", component: VideNotificationComponent ,canActivate:[authGuard]},
  { path: "listeVoiture", component: CreatCategorieVoitureComponent },


  { path :"admin",component:AdminTemplateComponent,canActivate:[AuthenticationGuard],children:[
      { path :"appartemet",component:CreatAppartemetComponent},
      { path :"categories",component:CreatCategoriesAppartementComponent},
      { path :"propraitaire",component:CreatPropAppartementComponent,canActivate:[AuthorizationGuard],data:{role:"ADMIN"}},
      { path :"listAppartemetCompoent",component:ListAppartemetComponent},
      { path: "createContrat" , component:CreatContratComponent},
      { path: "createFacteur" , component:CreatFactureComponent},
      { path: "createLocation" , component:CreatLocationComponent},
      // { path: "profile", component: ProfileComponent,canActivate:[authGuard] },
      { path: "profile", component: ProfileEzComponent,canActivate:[authGuard] }
    ]},


  { path: '**', component: NotFoundPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


