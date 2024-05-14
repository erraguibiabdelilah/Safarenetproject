import {Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../security/serviceAuth/auth.service";

@Component({
  selector: 'app-carousel-test',
  templateUrl: './carousel-test.component.html',
  styleUrl: './carousel-test.component.css'
})
export class CarouselTestComponent implements OnInit{

  constructor(private renderer: Renderer2,private authService:AuthService, private el: ElementRef,private router:Router) {}

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
    this.router.navigateByUrl("/reservationInformation");
  }

  RedirectTOLoginOrfacture() {
    if(this.authService.isAuthService){
      this.router.navigateByUrl("/reservationInformation")
    }

    else {
      this.router.navigateByUrl("/login")
    }
  }
}
