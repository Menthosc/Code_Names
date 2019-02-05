import { Component, OnInit } from '@angular/core';
import { JeuService } from '../jeu.service';


@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css']
})
export class JeuComponent implements OnInit {

  constructor(private jeuService: JeuService) { }

  ngOnInit() {
  }

}
