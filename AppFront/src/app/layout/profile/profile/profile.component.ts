import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../security/serviceAuth/auth.service";
import {NgIf} from "@angular/common";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {ClientService} from "../../../sahred/service/communService/client.service";
import {AgenceLocationService} from "../../../sahred/service/voitureService/agence-location.service";
import {PropAppartementService} from "../../../sahred/service/appartemetService/prop-appartement.service";
import {FormsModule} from "@angular/forms";
import {AgenceLocation} from "../../../sahred/model/voitureModel/agence-location.model";
import {PropAppartement} from "../../../sahred/model/appartemetModel/prop-appartement.model";
import {Client} from "../../../sahred/model/communModel/client.model";

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
    MatDivider,
    FormsModule
  ],
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {
  protected userRole: any

  agence = new AgenceLocation();
  //prop :PropAppartement=this.propAppartementService.getByusername(this.authService.username);
  client = new Client();

  fonction() {
    this.agenceLocationService.getByusername(this.authService.username).subscribe({
      next: data => {
        this.agence.usernameAgenceLoc= data.usernameAgenceLoc;
        this.agence.iceAgLoc= data.iceAgLoc;
      }
    })
  }

  constructor(protected authService: AuthService, private clientService: ClientService, private agenceLocationService: AgenceLocationService, private propAppartementService: PropAppartementService) {
  }

  ngOnInit(): void {
    this.fonction();
    console.log(this.authService.roles)
  }

  updateAgence(): void {
    console.log(this.agence);
    this.agenceLocationService.update(this.agence).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("le mise à jour effectue avec succes ")
        } else
          console.log(data);


      }
    });
  }
}

  /*updateProp(): void {
    this.propAppartementService.update(this.prop).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("le mise à jour effectue avec succes ")

        } else
          console.log(data);
      }
    });
  }*/

  /*updateClient(): void {
    console.log(this.client);
    this.clientService.update(this.client).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("mise à jour est effectuee avec succes ");
        } else
          console.log(data);
      }
    });

  }
}*/




