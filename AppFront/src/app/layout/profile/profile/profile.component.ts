import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../security/serviceAuth/auth.service";
import {NgIf} from "@angular/common";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  standalone: true,
  imports: [
    NgIf,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatDivider
  ],
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {
  protected userRole: any

  constructor(protected authService: AuthService) {
  }

  ngOnInit(): void {

console.log(this.authService.roles)
  }
}




