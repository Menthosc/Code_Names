import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { AppServiceService} from './app-service.service'
import { Case } from './case/case';

@Injectable({
  providedIn: 'root'
})
export class JeuService {
  public cases: Array<Case> = new Array<Case>();

  constructor(private appConfig: AppServiceService, private httpClient: HttpClient) { }
}

grilleId(id : number){
     this.httpClient.post("http://localhost:8080/api/grille", id).subscribe();
  }

  findAll(){

      this.httpClient.get("http://localhost:8080/api/listeCase").subscribe(resp =>
        {
          console.log(resp);
          this.cases = resp;
        }
        );
    }
