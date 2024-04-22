import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../serviceAuth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements  OnInit{

  formLogin! :FormGroup;
  constructor(private fb:FormBuilder,private authService:AuthService,private router:Router) {
  }

  ngOnInit(): void {
    this.formLogin=this.fb.group({
      username:this.fb.control(""),
      password: this.fb.control("")
    })
  }

  handleLogin(){

    let username=this.formLogin.value.username
    let password=this.formLogin.value.password

    console.log(username)
    console.log(password)

    this.authService.login(username,password).subscribe(
      {
        next :data => {
          console.log(data)

          this.authService.loadProfile(data);
          this.router.navigateByUrl("/admin")
        },
        error :err => {
          console.log("error")
          console.log(err)
        }
      }
    )
  }
}
