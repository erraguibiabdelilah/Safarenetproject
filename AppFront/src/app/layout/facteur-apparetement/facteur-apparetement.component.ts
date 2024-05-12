import {Component, ElementRef, OnInit} from '@angular/core';
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {ActivatedRoute} from "@angular/router";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {MatDatepickerInputEvent} from "@angular/material/datepicker";
import {DatePipe} from "@angular/common";

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

  constructor(private elementRef: ElementRef , private route: ActivatedRoute , private appartementService: AppartemetService ,private datePipe: DatePipe) { }

  ngOnInit(): void {
    const defaultActiveElement = this.elementRef.nativeElement.querySelector('.nav-item.active');
    this.toggleHoverEffect(defaultActiveElement);


    this.route.params.subscribe(params => {
      this.code = params['code'];
      console.log(this.code);
    });
    this.getApparetementByCode();
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


// ????????????????????????????? Calendrie////





  // myFilter = (date: Date | null): boolean => {
  //   // Example: Disable dates in the past
  //   const today = new Date();
  //   today.setHours(0, 0, 0, 0); // Set time to beginning of the day for comparison
  //   // @ts-ignore
  //   return date >= today; // Disable past dates
  // };
  myFilter = (date: Date | null): boolean => {
    // Example: Disable dates outside a specific range
    if (!date) {
      // Si la date est null, cela signifie qu'aucune date n'a été sélectionnée
      return false; // Empêche la sélection de la date
    }

    // Définissez votre intervalle de dates ici
    const dateDebut = new Date('5/18/2024'); // Date de début de l'intervalle
    const dateFin = new Date('5/21/2024'); // Date de fin de l'intervalle

    // Vérifiez si la date est dans l'intervalle spécifié
    return date < dateDebut || date > dateFin; // Retourne true si la date est dans l'intervalle
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

