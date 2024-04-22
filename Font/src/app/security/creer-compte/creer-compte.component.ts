import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../serviceAuth/auth.service";

@Component({
  selector: 'app-creer-compte',
  templateUrl: './creer-compte.component.html',
  styleUrls: ['./creer-compte.component.css']
})
export class CreerCompteComponent implements OnInit {
  searchFormGroup! : FormGroup;
  constructor(private fb : FormBuilder,private authService:AuthService,private  router:Router) { }

  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      username : this.fb.control(""),
      password : this.fb.control(""),
    });
  }


  protected readonly FormGroup = FormGroup;

  creeCompt() {
    let username=this.searchFormGroup.value.username;
    let password=this.searchFormGroup.value.password;
    console.log(username)
    console.log(password)
    this.authService.creeCompte(username,password).subscribe(
      {
        next:data=>{
          this.router.navigateByUrl("/login")
        },error:err => {
          console.log("error")
        }
      }
    );
  }
}
