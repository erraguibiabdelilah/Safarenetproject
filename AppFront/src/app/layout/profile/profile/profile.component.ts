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
import {Router, RouterLink} from "@angular/router";

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
    FormsModule,
    RouterLink
  ],
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {
  protected userRole: any

  agence = new AgenceLocation();
  prop =new PropAppartement;
  client = new Client();
  constructor(protected authService: AuthService, private clientService: ClientService, private agenceLocationService: AgenceLocationService, private propAppartementService:  PropAppartementService ,private router:Router) {
  }

  ngOnInit(): void {
    console.log(this.authService.roles)
    this.getPropre();
    this.getAgence();
    this.getClient();
  }
  getClient(){
    this.clientService.getByusername(this.authService.username).subscribe({
        next:data=>{
          console.log("data de getByUserName..."+data)
          this.client=data;

          console.log(this.client)
        },
        error:err => {
          console.log("error"+err)
        }
      }
    )
  }

  getAgence(){
    this.agenceLocationService.getByusername(this.authService.username).subscribe({
        next:data=>{
          console.log("data de getByUserName..."+data)
          this.agence=data;

          console.log(this.agence)
          console.log(data)
        },
        error:err => {
          console.log("error"+err)
        }
      }
    )
  }

  getPropre(){
    this.propAppartementService.getByusername(this.authService.username).subscribe({
        next:data=>{
          console.log("data de getByUserName..."+data)
          this.prop=data;

          console.log(this.prop)
          console.log(data)
        },
        error:err => {
          console.log("error"+err)
        }
      }
    )
  }
  updateClient(): void {
    console.log(this.client);
    this.client.cin = this.authService.dataUtilisateur.cin
    this.client.propAppartemenetDto = {
      nom: "",
      prenom: "",
      numTele: "",
      email: "",
      ribPropAppt: "",
      numCompteBkPropApp: "",
      cin: "",
      username: "",
      password: ""
    };
    this.client.agenceLocation= {
      iceAgLoc: 0,
      ribAgenceLoc: 0,
      raisonSocialAg: "",
      adresse: "",
      numTelephone: "",
      numCompteBkAgLoc: 0,
      usernameAgenceLoc: "",
      password: "",
      RCAgLoc: 0
    };
    this.clientService.update(this.client).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("mise à jour est effectuee avec succes ");
          this.router.navigateByUrl("/profileezz")
        } else
          console.log(data);
      },
      error:err=>{
        console.log(err)
      }
    });
  }
  updateAgence(): void {
    console.log(this.authService.agenceLocation.iceAgLoc+"    xxxxxxxx  "+this.authService.agenceLocation.usernameAgenceLoc+"yyyyyyyyyyy"+this.authService.username)
    console.log(this.agence);
    this.agence.iceAgLoc=this.authService.agenceLocation.iceAgLoc;
    this.agence.usernameAgenceLoc=this.authService.username;
    this.agenceLocationService.update(this.agence).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("le mise à jour effectue avec succes ")
          this.router.navigateByUrl(`/profileezz`)
        } else
          console.log(data);
      },
      error:err=>{
        console.log(err)
      }
    });
  }


  updateProp(): void {
    console.log("CIN"+this.authService.propAppartement.cin)
    console.log(this.prop);
    this.prop.cin=this.authService.propAppartement.cin;
    this.prop.username=this.authService.propAppartement.username ;

    this.propAppartementService.update(this.prop).subscribe({
      next: (data) => {
        if (data === 1) {
          alert("le mise à jour effectue avec succes ")
          this.router.navigateByUrl("/profileezz")
        } else
          console.log(data);
      },
      error:err => {
        console.log(err)
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




