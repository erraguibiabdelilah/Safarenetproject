import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {AuthService} from "../serviceAuth/auth.service";

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {

  constructor(private authService:AuthService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log(request.url)
    if(!request.url.includes("/login") && !request.url.includes("/user")){
      let newrrequest=request.clone({
        headers : request.headers.set('Authorization','Bearer '+this.authService.accessToken)
      })
      // @ts-ignore
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
