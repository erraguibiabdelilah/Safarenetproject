import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../../serviceAuth/auth.service";
import {Router} from "@angular/router";
import {AgenceLocationService} from "../../../sahred/service/voitureService/agence-location.service";
import {PropAppartementService} from "../../../sahred/service/appartemetService/prop-appartement.service";

@Component({
  selector: 'app-agence',
  templateUrl: './agence.component.html',
  styleUrl: './agence.component.css'
})
export class AgenceComponent {
  searchFormGroup! : FormGroup;
  constructor(public agenceLocationService :AgenceLocationService,private fb : FormBuilder,private  router:Router) {
  }


  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      username : this.fb.control(""),
      password : this.fb.control(""),
      iceAgLoc: this.fb.control("")
    });
  }



  creeCompt() {
    let username = this.searchFormGroup.value.username;
    let password = this.searchFormGroup.value.password;
    let iceAgLoc = this.searchFormGroup.value.iceAgLoc;
    console.log(username)
    console.log(password)
    console.log(iceAgLoc)
    this.agenceLocationService.creeCompte(iceAgLoc, username, password).subscribe(
      {
        next: data => {
          console.log(data)
          this.router.navigateByUrl("/login")
        }, error: err => {
          console.log("error")
        }
      }
    );
  }
}
