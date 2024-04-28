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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import {NoteAuthorizedComponent} from "./security/note-authorized/note-authorized.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {AuthService} from "./security/serviceAuth/auth.service";
import {AppHtppEzInterceptor} from "./security/interceptors/app-htpp-ez.interceptor";
import { ProfileComponent } from './layout/user/profile/profile.component';
import { NotFoundPageComponent } from './layout/not-found-page/not-found-page.component';
import { VideMessageComponent } from './layout/vide-message/vide-message.component';
import { VideNotificationComponent } from './layout/vide-notification/vide-notification.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {RadioButtonModule} from "primeng/radiobutton";
import {MenuModule} from "primeng/menu";
import {DropdownModule} from "primeng/dropdown";
import {PaginatorModule} from "primeng/paginator";
import {ToastModule} from "primeng/toast";
import {SplitButtonModule} from "primeng/splitbutton";
import {ToolbarModule} from "primeng/toolbar";
import {ButtonModule} from "primeng/button";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatDividerModule} from "@angular/material/divider";
import {MatCardContent, MatCardModule} from "@angular/material/card";
import {MatTableModule} from "@angular/material/table";
import {DialogModule} from "primeng/dialog";
import {LoginComponent} from "./security/login/login.component";
import {MessageService} from "primeng/api";
import {AvatarModule} from "primeng/avatar";
import {NgOptimizedImage} from "@angular/common";
import {AutoFocusModule} from "primeng/autofocus";
import {StepperModule} from "primeng/stepper";
import {IconFieldModule} from "primeng/iconfield";
import {InputIconModule} from "primeng/inputicon";
import {PasswordModule} from "primeng/password";
import {ToggleButtonModule} from "primeng/togglebutton";

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
    NavbarComponent,
    NoteAuthorizedComponent,
    AdminTemplateComponent,
    ProfileComponent,
    NotFoundPageComponent,
    VideMessageComponent,
    VideNotificationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatTableModule,
    MatCardContent,
    MatCardModule,
    MatDividerModule,
    MatPaginatorModule,
    MatSortHeader,
    MatSort,
    ButtonModule,
    ToolbarModule,
    SplitButtonModule,
    DialogModule,
    RadioButtonModule,
    MenuModule,
    ToastModule,
    MatInputModule,
    MatFormFieldModule,
    DropdownModule,
    PaginatorModule,
    DialogModule,
    AvatarModule,
    NgOptimizedImage,
    AutoFocusModule,
    StepperModule,
    IconFieldModule,
    InputIconModule,
    PasswordModule,
    ToggleButtonModule
  ],
  providers: [
    MessageService,
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: AppHtppEzInterceptor, multi: true },
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
