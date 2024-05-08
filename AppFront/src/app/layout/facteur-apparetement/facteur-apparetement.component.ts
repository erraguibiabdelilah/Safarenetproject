import {Component, ElementRef, OnInit} from '@angular/core';
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
import {ActivatedRoute} from "@angular/router";
import {Appartement} from "../../sahred/model/appartemetModel/appartement.model";
import {AppartemetService} from "../../sahred/service/appartemetService/appartemet.service";

@Component({
  selector: 'app-facteur-apparetement',
  templateUrl: './facteur-apparetement.component.html',
  styleUrl: './facteur-apparetement.component.css'
})
export class FacteurApparetementComponent implements OnInit{
  lastClicked: HTMLElement | null = null;
  code:any;
  apparetement=new Appartement();

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
}
