import {Component, ElementRef, OnInit} from '@angular/core';
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {ActivatedRoute} from "@angular/router";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";
import {MatDatepickerInputEvent} from "@angular/material/datepicker";

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

  constructor(private elementRef: ElementRef , private route: ActivatedRoute , private appartementService: AppartemetService) { }

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

<<<<<<< HEAD
  logDates() {
    console.log('nbrJours:', this.nbrJours);
    console.log('maDate:', this.maDate.toLocaleDateString('en-US', {
      month: '2-digit',
      day: '2-digit',
      year: 'numeric'
    }));
    console.log('maDate2:', this.maDate2.toLocaleDateString('en-US', {
      month: '2-digit',
      day: '2-digit',
      year: 'numeric'
    }));
  }


  get item(): Reservation {
    return this.reservationService.item;
  }

  set item(value: Reservation) {
    this.reservationService.item = value;
  }

  get items(): Array<Reservation> {
    return this.reservationService.items;
  }

  set items(value: Array<Reservation>) {
    this.reservationService.items = value;
  }


  saveObject() {
    this.reservationService.save().subscribe({
      next: (data) => {
        if (data == 1) {
          alert("Nice Bro")
          this.getReservationApp()
          this.ngOnInit()
        } else {
          console.log(data)
        }
      }
    })
  }

  handlReserve(){
    console.log(this.maDate2, 'yyyy-MM-dd')
    console.log(this.maDate, 'yyyy-MM-dd')
    this.item.dateFin=this.datePipe.transform(this.maDate2, 'yyyy-MM-dd')!;
    this.item.dateDebut=this.datePipe.transform(this.maDate, 'yyyy-MM-dd')!;


    this.item.appartement.id = this.apparetement.id;
    this.item.appartement.code = this.apparetement.code;
    this.item.appartement.wifi = this.apparetement.wifi;
    this.item.appartement.climatiseur = this.apparetement.climatiseur;
    this.item.appartement.loyerMensuel = this.apparetement.loyerMensuel;
    this.item.appartement.superficie = this.apparetement.superficie;
    this.item.appartement.ville = this.apparetement.ville;
    this.item.appartement.adresse = this.apparetement.adresse;
    this.item.appartement.nmbrPersont = this.apparetement.nmbrPersont;
    this.item.appartement.images = this.apparetement.images;
    this.item.appartement.nmbrPersont = this.apparetement.nmbrPersont;

    this.item.client.nom =this.authService.dataUtilisateur.nom;
    this.item.client.cin =this.authService.dataUtilisateur.cin;
    this.item.client.numTeleClient =this.authService.dataUtilisateur.numTeleClient;
    this.item.client.email_Client =this.authService.dataUtilisateur.email_Client;
    this.item.client.prenom =this.authService.dataUtilisateur.prenom;
    this.item.client.id =this.authService.dataUtilisateur.id;
    console.log("this.item")
    console.log(this.item)
    this.saveObject();
    console.log("this.authService.client.cin===>"+this.authService.dataUtilisateur.cin)
    console.log("this.authService.client.id===>"+this.authService.client.id)
    console.log("this.authService.dataUtilisateur.id===>"+this.authService.dataUtilisateur.id)
=======
    this.nbrJours=this.nbrJours+1 ;
    console.log(this.nbrJours)
>>>>>>> 7435dce5685de8fb7fe5b83ce7c8b689ea3dc74b
  }
}

