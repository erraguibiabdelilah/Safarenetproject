import { Component } from '@angular/core';
import {NgClass, NgIf} from "@angular/common";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgClass
  ],
  styleUrl: './home.component.css'
})
export class HomeComponent {
  public obejetClicked:boolean=true;


  public clicVoiture() {
    this.obejetClicked=true;
  }
  public clicApp() {
    this.obejetClicked=false;
  }

}
