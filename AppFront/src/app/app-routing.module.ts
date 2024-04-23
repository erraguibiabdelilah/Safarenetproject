import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreerCompteComponent} from "./security/creer-compte/creer-compte.component";
import {LoginComponent} from "./security/login/login.component";
import {
  CreatAppartemetComponent
} from "./view/appartemetComponent/appartemet/creat-appartemet/creat-appartemet.component";
import {NavbarComponent} from "./security/navbar/navbar.component";
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

const routes: Routes = [

  { path :"login", component : LoginComponent},
  { path :"creercompte", component : CreerCompteComponent},
  { path :"", redirectTo:"/login",pathMatch:"full"},

  { path :"admin",component:AdminTemplateComponent,canActivate:[AuthenticationGuard],children:[
      { path :"appartemet",component:CreatAppartemetComponent,canActivate:[AuthorizationGuard],data:{role:"ADMIN"}},
      { path :"categories",component:CreatCategoriesAppartementComponent,canActivate:[AuthorizationGuard],data:{role:"ADMIN"}},
      { path :"propraitaire",component:CreatPropAppartementComponent,canActivate:[AuthorizationGuard],data:{role:"ADMIN"}},
      { path :"listAppartemetCompoent",component:ListAppartemetComponent},
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
