import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./security/login/login.component";
import {CreerCompteComponent} from "./security/creer-compte/creer-compte.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {AuthenticationGuard} from "./security/guards/authentication.guard";
import {AuthorizationGuard} from "./security/guards/authorization.guard";
import {NoteAuthorizedComponent} from "./security/note-authorized/note-authorized.component";
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {CustomerAccountsComponent} from "./customer-accounts/customer-accounts.component";

const routes: Routes = [
  { path :"login", component : LoginComponent},
  { path :"creercompte", component : CreerCompteComponent},
  { path :"", redirectTo:"/login",pathMatch:"full"},
  { path :"admin", component : AdminTemplateComponent,canActivate:[AuthenticationGuard]
    ,children :[
      { path :"customers", component : CustomersComponent},
      { path :"accounts", component : AccountsComponent},
      { path :"new-customer", component : NewCustomerComponent,canActivate:[AuthorizationGuard],data:{role:"ADMIN"}},
      { path :"customer-accounts/:id", component : CustomerAccountsComponent},
      { path :"notAuthorized", component : NoteAuthorizedComponent},
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
