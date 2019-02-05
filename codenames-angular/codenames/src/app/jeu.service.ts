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


    reveler(){
      var cCase: String =$(this).find('span').text(); //récupère le mot de la carte dans la case cliquée
    	var that: any = $(this);
      var couleur: String = cCase.couleur ;
      this.httpClient.post("http://localhost:8080/api/jeu", cCase, this.httpOptions).subscribe();

      var texte: String = $(that).find('span').text();

      var monTexte: String = $('<h5> Le joueur a cliqué sur </h5>');

      monTexte.append(texte);
      $('section#infos').append(monTexte);

      var monTexte2: String = $('<h5> Et la couleur est... : </h5>');
      monTexte2.append(couleur);
      $('section#infos').append(monTexte2);

      var couleurNoire: String = "NOIRE" ;
      if (couleur == couleurNoire){
       var monTexte3 = $('<h5> Dommage... vous avez perdu </h5>');
       $('section#infos').append(monTexte3);
      }

      that.addClass(couleur);
      that.addClass('reveal');


    }


}
