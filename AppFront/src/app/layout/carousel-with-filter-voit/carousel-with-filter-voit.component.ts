import {Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-carousel-with-filter-voit',
  templateUrl: './carousel-with-filter-voit.component.html',
  styleUrl: './carousel-with-filter-voit.component.css'
})
export class CarouselWithFilterVOITComponent implements OnInit{
  public display:boolean=false;
  public formatcard:boolean=false;
  public selected:boolean =true;
  constructor(private renderer: Renderer2, private el: ElementRef,private router:Router) {}

  ngOnInit() {
    this.initSlider();
    // Ajoutez les écouteurs d'événements ici si nécessaire
  }

  initSlider() {
    const imageList = this.el.nativeElement.querySelector(".slider-wrapper .image-list");
    const slideButtons = this.el.nativeElement.querySelectorAll(".slider-wrapper .slide-button");
    const sliderScrollbar = this.el.nativeElement.querySelector(".container .slider-scrollbar");
    const scrollbarThumb = sliderScrollbar.querySelector(".scrollbar-thumb");
    const maxScrollLeft = imageList.scrollWidth - imageList.clientWidth;

    // Gestion des événements et manipulation du DOM ici
    // Assurez-vous d'utiliser this.renderer pour manipuler le DOM au lieu de document

    // Gestion du clic sur le bouton de défilement
    slideButtons.forEach((button: HTMLElement) =>{
      this.renderer.listen(button, 'click', () => {
        const direction = button.id === "prev-slide" ? -1 : 1;
        const scrollAmount = imageList.clientWidth * direction;
        imageList.scrollBy({ left: scrollAmount, behavior: "smooth" });
      });
    });

    // Gestion du redimensionnement de la fenêtre
    this.renderer.listen(window, 'resize', () => {
      // Réinitialise le slider en cas de redimensionnement
      this.initSlider();
    });
  }

  RedirectToFacture() {
    this.display=true;
  }

  handelVertical() {
    this.formatcard=false
  }
  handelHorizental() {
    this.formatcard=true;

  }
}
