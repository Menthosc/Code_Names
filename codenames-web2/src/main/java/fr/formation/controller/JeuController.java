package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import codenames.model.Carte;
import codenames.model.Case;
import codenames.model.Couleur;
import codenames.model.Difficulte;
import codenames.model.Grille;
import idao.IDAOCarte;
import idao.IDAOCase;
import idao.IDAOGrille;

@Controller
public class JeuController {
	
	@Autowired
	private IDAOCarte daoCarte ;
	
	@Autowired
	private IDAOCase daoCase ;
	
	@Autowired
	private IDAOGrille daoGrille ;
	
	
	@GetMapping(value="/jeu")
	public String jeuAfficher(Model model) {
	
		List <Carte> mesCartes = daoCarte.findAll();
		

		for (Carte c : mesCartes) {
			if (c.getLibelle()=="") {
				mesCartes.remove(c);	
			}
		}
		
		java.util.Collections.shuffle(mesCartes);
		
		
		List<Case> mesCases = new ArrayList<Case>();
		
			//Definition du niveau de difficulte
		int diff = 1 ;
	
			// Creation des cases avec couleur et carte
		for (int k = 0 ; k < 9; k++) {
			Couleur couleur = Couleur.ROUGE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < 8; k++) {
			Couleur couleur = Couleur.BLEUE;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < 8 - diff ; k++) {
			Couleur couleur = Couleur.NEUTRE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < diff; k++) {
			Couleur couleur = Couleur.NOIRE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
			// Melanger les cartes et creer la grille
		java.util.Collections.shuffle(mesCases);
		
		Grille maGrille = new Grille() ;
		maGrille.setCasesGrille(mesCases);
		Difficulte difficulte = null ;
		
		if (diff == 1) {
			difficulte = Difficulte.FACILE ;
		}
		if (diff == 2) {
			difficulte = Difficulte.MOYEN ;
		}
		if (diff == 3) {
			difficulte = Difficulte.DIFFICILE ;
		}
		
		maGrille.setDifficulte(difficulte);
		daoGrille.save(maGrille);
		
		List<Case> mesCasesGrille = maGrille.getCasesGrille();
		for (Case ca : mesCasesGrille) {
			ca.setGrilleCase(maGrille);
			daoCase.save(ca);
		}
		
		model.addAttribute("maGrille", maGrille);
		return "jeu";
	
	}

}