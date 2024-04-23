import {Component, OnInit} from '@angular/core';
import {AuthService} from "./security/serviceAuth/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements  OnInit{
  title = 'AppFront';

  constructor(private authService :AuthService) {

  }
  ngOnInit(): void {
    this.authService.loadJwtTokenFromLocalStrage();
  }

}
