import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditAppartemetComponent } from './view/appartemetComponent/appartemet/edit-appartemet/edit-appartemet.component';
import { ListAppartemetComponent } from './view/appartemetComponent/appartemet/list-appartemet/list-appartemet.component';
import { CreatAppartemetComponent } from './view/appartemetComponent/appartemet/creat-appartemet/creat-appartemet.component';
import { CreatCategoriesAppartementComponent } from './view/appartemetComponent/categoriesAppartement/creat-categories-appartement/creat-categories-appartement.component';
import { EditCategoriesAppartementComponent } from './view/appartemetComponent/categoriesAppartement/edit-categories-appartement/edit-categories-appartement.component';
import { ListCategoriesAppartementComponent } from './view/appartemetComponent/categoriesAppartement/list-categories-appartement/list-categories-appartement.component';
import { CreatPropAppartementComponent } from './view/appartemetComponent/propAppartement/creat-prop-appartement/creat-prop-appartement.component';
import { EditPropAppartementComponent } from './view/appartemetComponent/propAppartement/edit-prop-appartement/edit-prop-appartement.component';
import { ListPropAppartementComponent } from './view/appartemetComponent/propAppartement/list-prop-appartement/list-prop-appartement.component';
import { CreatClientComponent } from './view/communComponent/client/creat-client/creat-client.component';
import { EditClientComponent } from './view/communComponent/client/edit-client/edit-client.component';
import { ListClientComponent } from './view/communComponent/client/list-client/list-client.component';
import { CreatContratComponent } from './view/communComponent/contrat/creat-contrat/creat-contrat.component';
import { EditContratComponent } from './view/communComponent/contrat/edit-contrat/edit-contrat.component';
import { ListContratComponent } from './view/communComponent/contrat/list-contrat/list-contrat.component';
import { CreatFactureComponent } from './view/communComponent/facture/creat-facture/creat-facture.component';
import { EditFactureComponent } from './view/communComponent/facture/edit-facture/edit-facture.component';
import { ListFactureComponent } from './view/communComponent/facture/list-facture/list-facture.component';
import { CreatLocationComponent } from './view/communComponent/location/creat-location/creat-location.component';
import { EditLocationComponent } from './view/communComponent/location/edit-location/edit-location.component';
import { ListLocationComponent } from './view/communComponent/location/list-location/list-location.component';
import { CreatPaiementComponent } from './view/communComponent/paiement/creat-paiement/creat-paiement.component';
import { EditPaiementComponent } from './view/communComponent/paiement/edit-paiement/edit-paiement.component';
import { ListPaiementComponent } from './view/communComponent/paiement/list-paiement/list-paiement.component';
import { CreatReservationComponent } from './view/communComponent/reservation/creat-reservation/creat-reservation.component';
import { EditReservationComponent } from './view/communComponent/reservation/edit-reservation/edit-reservation.component';
import { ListReservationComponent } from './view/communComponent/reservation/list-reservation/list-reservation.component';
import { CreatAgenceLocationComponent } from './view/voitureComponent/agenceLocation/creat-agence-location/creat-agence-location.component';
import { EditAgenceLocationComponent } from './view/voitureComponent/agenceLocation/edit-agence-location/edit-agence-location.component';
import { ListAgenceLocationComponent } from './view/voitureComponent/agenceLocation/list-agence-location/list-agence-location.component';
import { CreatCategorieVoitureComponent } from './view/voitureComponent/categorieVoiture/creat-categorie-voiture/creat-categorie-voiture.component';
import { EditCategorieVoitureComponent } from './view/voitureComponent/categorieVoiture/edit-categorie-voiture/edit-categorie-voiture.component';
import { ListCategorieVoitureComponent } from './view/voitureComponent/categorieVoiture/list-categorie-voiture/list-categorie-voiture.component';
import { CreatModeleComponent } from './view/voitureComponent/modele/creat-modele/creat-modele.component';
import { EditModeleComponent } from './view/voitureComponent/modele/edit-modele/edit-modele.component';
import { ListModeleComponent } from './view/voitureComponent/modele/list-modele/list-modele.component';
import { CreatVoitureComponent } from './view/voitureComponent/voiture/creat-voiture/creat-voiture.component';
import { EditVoitureComponent } from './view/voitureComponent/voiture/edit-voiture/edit-voiture.component';
import { ListVoitureComponent } from './view/voitureComponent/voiture/list-voiture/list-voiture.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {LoginComponent} from "./security/login/login.component";
import {CreerCompteComponent} from "./security/creer-compte/creer-compte.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NavbarComponent} from "./security/navbar/navbar.component";
import {NoteAuthorizedComponent} from "./security/note-authorized/note-authorized.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {AuthService} from "./security/serviceAuth/auth.service";
import {AppHtppEzInterceptor} from "./security/interceptors/app-htpp-ez.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    EditAppartemetComponent,
    ListAppartemetComponent,
    CreatAppartemetComponent,
    CreatCategoriesAppartementComponent,
    EditCategoriesAppartementComponent,
    ListCategoriesAppartementComponent,
    CreatPropAppartementComponent,
    EditPropAppartementComponent,
    ListPropAppartementComponent,
    CreatClientComponent,
    EditClientComponent,
    ListClientComponent,
    CreatContratComponent,
    EditContratComponent,
    ListContratComponent,
    CreatFactureComponent,
    EditFactureComponent,
    ListFactureComponent,
    CreatLocationComponent,
    EditLocationComponent,
    ListLocationComponent,
    CreatPaiementComponent,
    EditPaiementComponent,
    ListPaiementComponent,
    CreatReservationComponent,
    EditReservationComponent,
    ListReservationComponent,
    CreatAgenceLocationComponent,
    EditAgenceLocationComponent,
    ListAgenceLocationComponent,
    CreatCategorieVoitureComponent,
    EditCategorieVoitureComponent,
    ListCategorieVoitureComponent,
    CreatModeleComponent,
    EditModeleComponent,
    ListModeleComponent,
    CreatVoitureComponent,
    EditVoitureComponent,
    ListVoitureComponent,
    LoginComponent,
    CreerCompteComponent,
    NavbarComponent,
    NoteAuthorizedComponent,
    AdminTemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: AppHtppEzInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
