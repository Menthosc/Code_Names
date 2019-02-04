import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {
  public url: string = "http://localhost:8080/api/";
  constructor() { }
}
