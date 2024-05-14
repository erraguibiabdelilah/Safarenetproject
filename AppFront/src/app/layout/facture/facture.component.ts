import { Component } from '@angular/core';
import html2canvas from "html2canvas";
import jsPDF from "jspdf";

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrl: './facture.component.css'
})
export class FactureComponent {

  exportToPDF() {
    const content = document.getElementById('content');

    // @ts-ignore
    html2canvas(content, { scale: 2 }).then(canvas => { // Utiliser une échelle de 2x pour augmenter la résolution
      const imgData = canvas.toDataURL('image/jpeg', 1.0); // Utiliser le format JPEG avec une qualité maximale

      const pdf = new jsPDF();
      const imgWidth = 210; // Largeur de la page A4
      const imgHeight = canvas.height * imgWidth / canvas.width;

      const marginLeft = 20; // Marge à gauche
      const marginRight = 20; // Marge à droite
      const marginTop = (pdf.internal.pageSize.getHeight() - imgHeight) / 2;

      pdf.addImage(imgData, 'JPEG', marginLeft, marginTop, imgWidth - marginLeft - marginRight, imgHeight); // Dessiner le contenu avec les marges
      pdf.save('export.pdf');
    });
  }


}
