import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http' ;
import { AppServiceService} from './app-service.service'
import { Case } from './case/case';
import { ActionJoueur } from './action-joueur/action';

@Injectable({
  providedIn: 'root'
})
export class JeuService {
  public cases: any = new Array<Case>();
  public action2: any = new ActionJoueur();
  private httpOptions: any ;
  private scores: any ;

  constructor(private appConfig: AppServiceService, private httpClient: HttpClient) {

    // en-tete avec les identifiants
   let myHeaders: HttpHeaders = new HttpHeaders;

   //on appliques les identifiants a l'en tete
   myHeaders = myHeaders.append("Authorization", "Basic " + btoa("user:123456"));


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
        this.httpClient.get("http://localhost:8080/api/listeCase" + id, this.httpOptions).subscribe(resp =>
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

      let nomCase:String = c.carte.libelle;
      let couleur: String = c.couleur;
      let infoJoueur: String = "";
      let infoCouleur: String = "";
      let infoCouleurNoir: String = "";
      let infoReveal: String = "reveal";

      this.httpClient.post("http://localhost:8080/api/jeu", nomCase,this.httpOptions).subscribe();

        infoJoueur = " Le joueur a cliqué sur ";
        infoCouleur = "Et la couleur est ";

        var couleurNoire = "NOIRE" ;

        if (couleur == couleurNoire){
         infoCouleurNoir = "Dommage... vous avez perdu !";
         return  infoCouleurNoir;
        }

        return infoReveal;
        return couleur;
        return infoJoueur;
        return infoCouleur;

  
    }



}
