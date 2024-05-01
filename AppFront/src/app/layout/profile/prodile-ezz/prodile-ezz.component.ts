import { Component } from '@angular/core';
import {AuthService} from "../../../security/serviceAuth/auth.service";

@Component({
  selector: 'app-prodile-ezz',
  templateUrl: './prodile-ezz.component.html',
  styleUrl: './prodile-ezz.component.css'
})
export class ProdileEzzComponent {
  constructor(protected authService:AuthService) {

  }
}
