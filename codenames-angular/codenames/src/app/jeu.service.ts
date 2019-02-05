import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { AppServiceService} from './app-service.service'
import { Case } from './case/case';
import { ActionJoueur } from './action-joueur/action';

@Injectable({
  providedIn: 'root'
})
export class JeuService {
  public cases: any = null;
  public action2: any = new ActionJoueur();
  private httpOptions: any ;
  private scores: any ;
    private infos: Array<string> = new Array<string>();

  constructor(private appConfig: AppServiceService, private httpClient: HttpClient) {

    // en-tete avec les identifiants
   let myHeaders: HttpHeaders = new HttpHeaders;

   //on appliques les identifiants a l'en tete
   myHeaders = null;//myHeaders.append("Authorization", "Basic " + btoa("user:123456"));


    // options http pour la requete
    this.httpOptions = {
      headers: myHeaders
    };

   }


  findgrilleId(id : number){
     this.httpClient.post("http://localhost:8080/api/grille", id, this.httpOptions).subscribe();
  }

  findAll(
    // id : number
  ){
    let id:number = 54 ; // a modifier pour recuperer l'id de la grille utilisee
    if (this.cases == null) {
        this.httpClient.get("http://localhost:8080/api/listeCase/" + id, this.httpOptions).subscribe(resp =>
          {
            console.log(resp);
            this.cases = resp;
          }
          );
        }
    }

  action(){
    this.httpClient.get("http://localhost:8080/api/case", this.httpOptions).subscribe(resp =>
      {
        console.log(resp);
        this.action2 = resp;
      }
      );
    }

  score(){
    this.httpClient.get("http://localhost:8080/api/scores", this.httpOptions).subscribe(resp =>
      {
        console.log(resp);
        this.scores = resp;
      }
      );
  }

    reveler(c:Case){
      let id:number = 54 ;
      let nomCase:String = c.carte.libelle;
      let couleur: String = c.couleur;

      let actionJoueur = { "nomCase": nomCase, "grilleId": id };

      this.httpClient.post("http://localhost:8080/api/case", actionJoueur, this.httpOptions).subscribe(resp => {
          console.log(resp);
          let info = "";

          if (resp.couleur == "NOIRE") {
             info = "Dommage... vous avez perdu !";
          }

          else {
            info = " Le joueur a cliqué sur " + resp.carte.libelle + ". Et la couleur est " + resp.couleur;
          }

          this.infos.push(info);


          //Case révélée
          for (let c of this.cases) {
            if (c.id == resp.id) {
              c.couleur = resp.couleur;
              c.revelee = true;
              break;
            }
          }
      });
    }



}
