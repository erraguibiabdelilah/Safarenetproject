import {Component, OnInit} from '@angular/core';
import {PropAppartementService} from "../../../sahred/service/appartemetService/prop-appartement.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-prop',
  templateUrl: './prop.component.html',
  styleUrl: './prop.component.css'
})
export class PropComponent implements OnInit{
  searchFormGroup! : FormGroup;
  constructor(public appartemetService :PropAppartementService,private fb : FormBuilder,private  router:Router) {
  }


  ngOnInit(): void {
    this.searchFormGroup=this.fb.group({
      username : this.fb.control(""),
      password : this.fb.control(""),
      cin: this.fb.control("")
    });
  }



  creeCompt() {
    let username=this.searchFormGroup.value.username;
    let password=this.searchFormGroup.value.password;
    let cin= this.searchFormGroup.value.cin;
    console.log(username)
    console.log(password)
    console.log(cin)
    this.appartemetService.creeCompte(cin ,username,password).subscribe(
      {
        next:data=>{
          console.log(data)
          this.router.navigateByUrl("/login")
        },error:err => {
          console.log("error")
        }
      }
    );
  }






}
