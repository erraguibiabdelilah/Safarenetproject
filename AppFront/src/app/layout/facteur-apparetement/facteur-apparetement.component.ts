import {Component, ElementRef, OnInit} from '@angular/core';
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {ActivatedRoute} from "@angular/router";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {DatePipe} from "@angular/common";
import { MatDatepickerInputEvent} from "@angular/material/datepicker";
import {Reservation} from "../../sahred/model/communModel/reservation.model";
import {ReservationService} from "../../sahred/service/communService/reservation.service";

@Component({
  selector: 'app-facteur-apparetement',
  templateUrl: './facteur-apparetement.component.html',
  styleUrl: './facteur-apparetement.component.css'
})
export class FacteurApparetementComponent implements OnInit{

  lastClicked: HTMLElement | null = null;
  code:any;
  apparetement=new Appartement();
  nbrJours=0;
  // maDate:any;
  maDate = new Date();
  dataReservationAppartement:Array<Reservation>=new Array<Reservation>();
  tableauDate:any;
  days: string[] = [];
  constructor(private elementRef: ElementRef ,private reservationService:ReservationService, private route: ActivatedRoute , private appartementService: AppartemetService ,private datePipe: DatePipe) { }

  ngOnInit(): void {
    const defaultActiveElement = this.elementRef.nativeElement.querySelector('.nav-item.active');
    this.toggleHoverEffect(defaultActiveElement);
    this.route.params.subscribe(params => {
      this.code = params['code'];
      console.log(this.code);
    });
    this.getApparetementByCode();
    this.getReservationApp();

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



getApparetementByCode(){
    this.appartementService.get(this.code).subscribe({
      next:data=>{
        console.log(data)
        this.apparetement = data ;
      },
      error:err=>{console.log(err)}
    })
}

  getReservationApp() {
    this.reservationService.findReservationbyAppCode(this.code).subscribe({
      next: (data) => {
        this.dataReservationAppartement = data;
        this.tableauDate = this.dataReservationAppartement.map(e => ({
          dateDebut: new Date(e.date_Debut),
          dateFin: new Date(e.date_Fin)
        }));

        console.log("tableau de dates");
        console.log(this.tableauDate);


        for (let i = 0; i < this.tableauDate.length; i++) {
          let currentDate = new Date(this.tableauDate[i].dateDebut);
          const endDate = this.tableauDate[i].dateFin;

          while (currentDate <= endDate) {
            this.days.push(currentDate.toLocaleDateString('en-US', { month: '2-digit', day: '2-digit', year: 'numeric' }));
            currentDate.setDate(currentDate.getDate() + 1);
          }
        }

        console.log("days");
        console.log(this.days.toString());
      }
    });
  }



// ????????????????????????????? Calendrie////





  // myFilter = (date: Date | null): boolean => {
  //   // Example: Disable dates in the past
  //   const today = new Date();
  //   today.setHours(0, 0, 0, 0); // Set time to beginning of the day for comparison
  //   // @ts-ignore
  //   return date >= today; // Disable past dates
  // };

  // myFilter = (date: Date | null): boolean => {
  //   if (!date) {
  //     return false;
  //   }
  //
  //
  //   // @ts-ignore
  //   return !this.days.includes(date.getDate()); // Filtrer la date si elle ne correspond à aucun intervalle
  // };

// Exemple d'utilisation


  myFilter = (date: Date | null): boolean => {
    if (!date) {
      return false; // Empêche la sélection de la date si elle est null
    }

    // Conversion de la date en format "mm/dd/yyyy"
    const dateString = (date.getMonth() + 1).toString().padStart(2, '0') + '/' + date.getDate().toString().padStart(2, '0') + '/' + date.getFullYear().toString();

    // Vérification si la date est incluse dans this.days
    return !this.days.includes(dateString);
  };






  onDateInput(event: MatDatepickerInputEvent<Date>) {
    this.maDate.setDate(event.value!.getDate()) ;
    const formattedDate: string = this.maDate.getFullYear() + '-' +
      ('0' + (this.maDate.getMonth() + 1)).slice(-2) + '-' +
      ('0' + this.maDate.getDate()).slice(-2);
    console.log('Formatted Date:', formattedDate);
    this.maDate.setDate(Number(formattedDate));
  }

  decrement() {
    if(this.nbrJours>0){
      this.nbrJours=this.nbrJours-1;
    }
    console.log(this.nbrJours)
  }

  increment() {

    this.nbrJours=this.nbrJours+1 ;
    this.maDate.setDate(this.maDate.getDate()+1)

    console.log(this.nbrJours)
    console.log(this.maDate)

  }
}


