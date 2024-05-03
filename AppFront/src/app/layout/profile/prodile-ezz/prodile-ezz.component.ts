import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../security/serviceAuth/auth.service";
import {ClientService} from "../../../sahred/service/communService/client.service";
import {AgenceLocationService} from "../../../sahred/service/voitureService/agence-location.service";
import {PropAppartementService} from "../../../sahred/service/appartemetService/prop-appartement.service";
import {Client} from "../../../sahred/model/communModel/client.model";

@Component({
  selector: 'app-prodile-ezz',
  templateUrl: './prodile-ezz.component.html',
  styleUrl: './prodile-ezz.component.css'
})
export class ProdileEzzComponent implements OnInit{

  // Variable
  client:Client=new Client();

  constructor(protected authService:AuthService, private clientService: ClientService, private agenceLocationService: AgenceLocationService, private propAppartementService: PropAppartementService) {}
  ngOnInit(): void {
    this.premierLettre()
    this.fonctionP()
    this.getClient()
    console.log("get Client"+this.authService.dataUtilisateur.cin)
  }


  getClient(){
    this.clientService.getByusername(this.authService.username).subscribe({
      next:data=>{
        this.client=data
      },
      error:err=>{
        console.log(err)
      }
    })
  }




  lettere !:string ;
  premierLettre(){
    this.lettere = this.authService.username[0];
    console.log(this.lettere)
  }
  pElement: HTMLElement | null = document.querySelector('p');
  fonctionP(){
    if (window.getSelection) {
      const selection: Selection | null = window.getSelection();
      if (selection) {
        selection.removeAllRanges();
      }
    }
  }
}
