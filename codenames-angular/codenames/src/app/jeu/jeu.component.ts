import { Component, OnInit } from '@angular/core';
import { JeuService } from '../jeu.service';


@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css']
})
export class JeuComponent implements OnInit {

  constructor(private jeuService: JeuService) {
    jeuService.findAll();
  }

  ngOnInit() {
  }



  getClasse(c: any) {
    if (c.revelee) {
      return "reveal " + c.couleur;
    }

    return "";
  }
}
