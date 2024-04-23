import { TestBed } from '@angular/core/testing';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse} from '@angular/common/http';
import { appHtppEzInterceptor } from './app-htpp-ez.interceptor';
import {Observable, of} from "rxjs";
import {Injectable} from "@angular/core";

describe('appHtppEzInterceptor', () => {
  let interceptor: HttpInterceptor;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: appHtppEzInterceptor, useClass: appHtppEzInterceptor }
      ]
    });

    interceptor = TestBed.inject(appHtppEzInterceptor);
  });

  it('should be created', () => {
    expect(interceptor).toBeTruthy();
  });

  it('should intercept requests', () => {
    const req = new HttpRequest<any>('GET', 'https://example.com/api');
    const handler: HttpHandler = {
      handle: (request: HttpRequest<any>): Observable<HttpEvent<any>> => {
        // Mocking the response here
        return of(new HttpResponse({ status: 200, body: {} }));
      }
    };

    const intercepted = interceptor.intercept(req, handler);

    expect(intercepted).toBeTruthy();
    // You can add more expectations here based on your interceptor behavior
  });
});
