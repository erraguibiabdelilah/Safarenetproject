import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreerCompteComponent} from "./security/creer-compte/creer-compte.component";
import {LoginComponent} from "./security/login/login.component";
import {
  CreatAppartemetComponent
} from "./view/appartemetComponent/appartemet/creat-appartemet/creat-appartemet.component";
import {NavbarComponent} from "./security/navbar/navbar.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";

const routes: Routes = [
  { path :"login", component : LoginComponent},
  { path :"creercompte", component : CreerCompteComponent},
  { path :"", redirectTo:"/login",pathMatch:"full"},
  { path :"appartemet",component:CreatAppartemetComponent},
  { path :"admin",component:AdminTemplateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
