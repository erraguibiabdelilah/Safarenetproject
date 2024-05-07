import {AfterViewInit, Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import {AuthService} from "../../security/serviceAuth/auth.service";
import {Router} from "@angular/router";
import {Client} from "../../sahred/model/communModel/client.model";
import {PropAppartement} from "../../sahred/model/appartemetModel/prop-appartement.model";
import {AgenceLocation} from "../../sahred/model/voitureModel/agence-location.model";
import {ClientService} from "../../sahred/service/communService/client.service";
import {PropAppartementService} from "../../sahred/service/appartemetService/prop-appartement.service";
import {AgenceLocationService} from "../../sahred/service/voitureService/agence-location.service";
@Component({
  selector: 'app-reservation-information',
  templateUrl: './reservation-information.component.html',
  styleUrl: './reservation-information.component.css'
})
export class ReservationInformationComponent  implements OnInit{
  lastClicked: HTMLElement | null = null;
  public dataLoaded!:Client;

  constructor(private elementRef: ElementRef , private authService:AuthService , private router:Router, private clientService :ClientService,private propAppService:PropAppartementService
    , private agenceLocService:AgenceLocationService , private clienService:ClientService) { }

  ngOnInit(): void {
    const defaultActiveElement = this.elementRef.nativeElement.querySelector('.nav-item.active');
    this.toggleHoverEffect(defaultActiveElement);
    this.getDataByUsername();
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
}
