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
import { CreatVoitureComponent } from './view/voitureComponent/voiture/creat-voiture/creat-voiture.component';
import { EditVoitureComponent } from './view/voitureComponent/voiture/edit-voiture/edit-voiture.component';
import { ListVoitureComponent } from './view/voitureComponent/voiture/list-voiture/list-voiture.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import {NoteAuthorizedComponent} from "./security/note-authorized/note-authorized.component";
import {AdminTemplateComponent} from "./security/admin-template/admin-template.component";
import {AuthService} from "./security/serviceAuth/auth.service";
import {AppHtppEzInterceptor} from "./security/interceptors/app-htpp-ez.interceptor";
import { NotFoundPageComponent } from './layout/not-found-page/not-found-page.component';
import { VideMessageComponent } from './layout/vide-message/vide-message.component';
import { VideNotificationComponent } from './layout/vide-notification/vide-notification.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {RadioButtonModule} from "primeng/radiobutton";
import {MenuModule} from "primeng/menu";
import {DropdownModule} from "primeng/dropdown";
import {PaginatorModule} from "primeng/paginator";
import {MatDrawerContainer, MatDrawerContent, MatSidenav, MatSidenavModule} from "@angular/material/sidenav";
import {MatList, MatListItem, MatNavList} from "@angular/material/list";
import {MatIcon, MatIconModule} from "@angular/material/icon";
import {MatMenu, MatMenuModule, MatMenuTrigger} from "@angular/material/menu";
import {MatBadge, MatBadgeModule} from "@angular/material/badge";
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {RippleModule} from "primeng/ripple";
import {ChipsModule} from "primeng/chips";
import {LoginComponent} from "./security/login/login.component";
import {MatTableModule} from "@angular/material/table";
import {MatCardContent, MatCardModule} from "@angular/material/card";
import {MatDividerModule} from "@angular/material/divider";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {ToolbarModule} from "primeng/toolbar";
import {ButtonModule} from "primeng/button";
import {SplitButtonModule} from "primeng/splitbutton";
import {DialogModule} from "primeng/dialog";
import {ToastModule} from "primeng/toast";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MessageService} from "primeng/api";
import { CarouselTestComponent } from './layout/carousel-test/carousel-test.component';
import {ProfileComponent} from "./layout/profile/profile/profile.component";
import { CarouselWithAnimationComponent } from './layout/carousel-with-animation/carousel-with-animation.component';

import {SearchIcon} from "primeng/icons/search";
import {HomeComponent} from "./layout/home/home.component";
import { ProdileEzzComponent } from './layout/profile/prodile-ezz/prodile-ezz.component';
// import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
// import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import { ReservationInformationComponent } from './layout/reservation-information/reservation-information.component';
import { FacteurApparetementComponent } from './layout/facteur-apparetement/facteur-apparetement.component';
import {TranslateModule} from "@ngx-translate/core";
import {DragDirective} from "./security/drag/drg.directive";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";

export function HttpLoaderFactory(http: HttpClient) {
  // return new TranslateHttpLoader(http);
}


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
    CreatVoitureComponent,
    EditVoitureComponent,
    ListVoitureComponent,
    LoginComponent,
    NavbarComponent,
    NoteAuthorizedComponent,
    AdminTemplateComponent,
    NotFoundPageComponent,
    VideMessageComponent,
    VideNotificationComponent,
    CarouselTestComponent,
    CarouselWithAnimationComponent,
    HomeComponent,
    ProdileEzzComponent,
    ReservationInformationComponent,
    DragDirective,
    FacteurApparetementComponent,

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
        MatSortModule,
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

        MatDrawerContent,
        MatListItem,

      MatGridList,
      MatGridTile,
        MatIconModule,
        MatDrawerContainer,
        MatNavList,
        MatMenuTrigger,
        MatMenuModule,
        MatBadgeModule,
        MatToolbarModule,
        MatButtonModule,
        MatSidenavModule,
        MatList,
        RippleModule,
        ChipsModule,
        SearchIcon,
        TranslateModule,
      TranslateModule.forRoot()
      // TranslateModule.forRoot({
        //     loader: {
        //       provide: TranslateLoader,
        //       useFactory: HttpLoaderFactory,
        //       deps: [HttpClient]
        //     }
        //   }
        // ),


    ],
  providers: [
    MessageService,
    AuthService,
    {provide: HTTP_INTERCEPTORS, useClass: AppHtppEzInterceptor, multi: true},
    provideAnimationsAsync()
  ],
  exports: [
    CarouselTestComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
