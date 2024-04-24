import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../serviceAuth/auth.service";
import {Client} from "../../../sahred/model/communModel/client.model";

@Component({
  selector: 'app-creer-compte',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  searchFormGroup! : FormGroup;


  constructor(private fb : FormBuilder,private authService:AuthService,private  router:Router) { }

  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      username : this.fb.control(""),
      password : this.fb.control(""),
      cin : this.fb.control(""),
    });
  }


  protected readonly FormGroup = FormGroup;

  creeCompt() {
    this.authService.client.cin=this.searchFormGroup.value.cin;
    this.authService.client.username_Client=this.searchFormGroup.value.username;
    this.authService.client.password_Client=this.searchFormGroup.value.password;

    console.log(this.authService.client)
    this.authService.creeCompte(this.authService.client).subscribe(
      {
        next:data=>{
          console.log(data)
          this.router.navigateByUrl("/login")
        }
        ,error:err => {
          console.log("error ezzaim")
        }
      }
    );
  }
}
