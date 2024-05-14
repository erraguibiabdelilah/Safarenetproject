import {AfterViewInit, Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import {AuthService} from "../../security/serviceAuth/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Client} from "../../sahred/model/communModel/client.model";
import {AgenceAppartement} from "../../sahred/model/appartemetModel/AgenceAppartement.model";
import {AgenceLocation} from "../../sahred/model/voitureModel/agence-location.model";
import {ClientService} from "../../sahred/service/communService/client.service";
import {AgenceAppartementService} from "../../sahred/service/appartemetService/agence-appartement.service";
import {AgenceLocationService} from "../../sahred/service/voitureService/agence-location.service";
import {VoitureService} from "../../sahred/service/voitureService/voiture.service";
import {Voiture} from "../../sahred/model/voitureModel/voiture.model";
import {MatDatepickerInputEvent} from "@angular/material/datepicker";



@Component({
  selector: 'app-reservation-information',
  templateUrl: './reservation-information.component.html',
  styleUrl: './reservation-information.component.css',


})
export class ReservationInformationComponent  implements OnInit{
  minDate: Date;
  maxDate: Date;
  lastClicked: HTMLElement | null = null;
  public dataLoaded!:Client;
  matricule:any;
  voitureData=new Voiture();
  nbrJours=0;

  constructor(private elementRef: ElementRef , private authService:AuthService , private router:Router, private clientService :ClientService,private propAppService:AgenceAppartementService
    , private voitureService:VoitureService , private route: ActivatedRoute ,private clienService:ClientService) {
    const currentYear = new Date().getFullYear();
    this.minDate = new Date(currentYear - 20, 0, 1);
    this.maxDate = new Date(currentYear + 1, 11, 31);
  }

  ngOnInit(): void {
    const defaultActiveElement = this.elementRef.nativeElement.querySelector('.nav-item.active');
    this.toggleHoverEffect(defaultActiveElement);
    this.getDataByUsername();


    this.route.params.subscribe(params => {
      this.matricule = params['matricule'];
      console.log(this.matricule);
    });
    this.getVoitureByMatricule();
  }

  getVoitureByMatricule(){
    this.voitureService.get(this.matricule).subscribe({
      next:data=>{
        this.voitureData=data ;
        console.log(data)
      },
      error:err=>{console.log(err)}
    })
  }
  toggleHoverEffect(element: EventTarget | null) {
    if (element instanceof HTMLElement) {
      // Supprimer le style de survol de l'élément précédemment cliqué
      if (this.lastClicked !== null) {
        this.lastClicked.style.borderBottom = "none";
        this.lastClicked.style.cursor = "default";
      }

      // Appliquer le style de survol à l'élément actuellement cliqué
      element.style.borderBottom = "2px solid blue";
      element.style.cursor = "pointer";

      // Enregistrer l'élément actuellement cliqué
      this.lastClicked = element;
    }
  }


  scrollTo(id: string) {
    const element = this.elementRef.nativeElement.querySelector(`#${id}`);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });
    }
  }

  handleClick(id: string) {
    // this.toggleHoverEffect(id);
    this.scrollTo(id);
  }

  exportToPDF() {
    const content = document.getElementById('content');

    // @ts-ignore
    html2canvas(content, { scale: 2 }).then(canvas => { // Utiliser une échelle de 2x pour augmenter la résolution
      const imgData = canvas.toDataURL('image/jpeg', 1.0); // Utiliser le format JPEG avec une qualité maximale

      const pdf = new jsPDF();
      const imgWidth = 210; // Largeur de la page A4
      const imgHeight = canvas.height * imgWidth / canvas.width;

      pdf.addImage(imgData, 'JPEG', 0, 0, imgWidth, imgHeight); // Utiliser le format JPEG pour une meilleure qualité
      pdf.save('export.pdf');
    });
  }
  getDataByUsername(){
    this.clienService.getByusername(this.authService.username).subscribe({
      next:(data)=>{
        this.dataLoaded=data;
      }
    })
  }

  RedirectversFacture_Paiment() {
    if(this.authService.isAuthService){
      if(this.authService.roles.includes('USER')){
        if (this.dataLoaded.nom && this.dataLoaded.prenom){
          this.router.navigateByUrl('/facture')
        } else this.router.navigateByUrl('/profile')
      }else {
        this.router.navigateByUrl('/facture')
      }
    }else {
      this.router.navigateByUrl('/login');
    }
  }

// ????????????????????????????? Calendrie////





  myFilter = (date: Date | null): boolean => {
    // Example: Disable dates in the past
    const today = new Date();
    today.setHours(0, 0, 0, 0); // Set time to beginning of the day for comparison
    // @ts-ignore
    return date >= today; // Disable past dates
  };




  dateSelected(event: MatDatepickerInputEvent<Date>) {
    console.log('Selected date:', event.value);
  }

  decrement() {
    if(this.nbrJours>0){
      this.nbrJours=this.nbrJours-1;
    }
    console.log(this.nbrJours)
  }

  increment() {

    this.nbrJours=this.nbrJours+1 ;
    console.log(this.nbrJours)
  }
}
