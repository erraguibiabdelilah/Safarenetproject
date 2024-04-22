import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './security/navbar/navbar.component';
import { CustomersComponent } from './customers/customers.component';
import { AccountsComponent } from './accounts/accounts.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { CustomerAccountsComponent } from './customer-accounts/customer-accounts.component';
import {AccountsService} from "./services/accounts.service";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {LoginComponent} from "./security/login/login.component";
import {NoteAuthorizedComponent} from "./security/note-authorized/note-authorized.component";
import {CreerCompteComponent} from "./security/creer-compte/creer-compte.component";
import {AppHttpInterceptor} from "./security/interceptors/app-http.interceptor";
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    AccountsComponent,
    NewCustomerComponent,
    CustomerAccountsComponent,
    AdminTemplateComponent,
    LoginComponent,
    NoteAuthorizedComponent,
    CreerCompteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  // providers: [AccountsService,Pro],
  providers: [
    {provide: HTTP_INTERCEPTORS,useClass : AppHttpInterceptor,multi :true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
