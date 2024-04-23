import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from "../serviceAuth/auth.service";
@Injectable()
export class AppHtppEzInterceptor implements HttpInterceptor {

  token :any;
  constructor(private authService: AuthService) {}
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(!request.url.includes("/login") && !request.url.includes("/user")){
      let newrrequest=request.clone({
        headers : request.headers.set('Authorization','Bearer '+this.authService.accessToken)
      })
      return next.handle(newrrequest).pipe(
        catchError(err => {
          if(err.status==401){
            this.authService.logout();
          }
          return throwError(err.message)
        })
      )

    }else {
      return next.handle(request);
    }
  }
}
