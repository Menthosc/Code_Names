import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { AppServiceService} from './app-service.service'
import { Case } from './case/case';
import { ActionJoueur } from './action-joueur/action';

@Injectable({
  providedIn: 'root'
})
export class JeuService {
  public cases: Array<Case> = new Array<Case>();
  public action: ActionJoueur = new ActionJoueur();

  constructor(private appConfig: AppServiceService, private httpClient: HttpClient) {

    private appConfig: AppConfigService, private httpClient: HttpClient) {

    // en-tete avec les identifiants
   let myHeaders: HttpHeaders = new HttpHeaders;

   //on appliques les identifiants a l'en tete
   myHeaders = myHeaders.append("Authorization", "Basic " + btoa("user:123456"));


    // options http pour la requete
    this.httpOptions = {
      headers: myHeaders
    };

   }
}

  grilleId(id : number){
     this.httpClient.post("http://localhost:8080/api/grille", id, this.httpOptions).subscribe();
  }

  findAll(id : number){
    id = 124 ; // a modifier pour recuperer l'id de la grille utilisee
      this.httpClient.get("http://localhost:8080/api/listeCase" + id, this.httpOptions).subscribe(resp =>
        {
          console.log(resp);
          this.cases = resp;
        }
        );
    }

  action(){
    this.httpClient.get("http://localhost:8080/api/case", this.httpOptions).subscribe(resp =>
      {
        console.log(resp);
        this.action = resp;
      }
    }
