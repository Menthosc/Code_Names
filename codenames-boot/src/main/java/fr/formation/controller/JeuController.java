package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import codenames.model.Carte;
import codenames.model.Case;
import codenames.model.Couleur;
import codenames.model.Difficulte;
import codenames.model.Grille;
import codenames.model.Scores;
import codenames.model.Utilisateur;
import fr.formation.dao.IDAOCarte;
import fr.formation.dao.IDAOCase;
import fr.formation.dao.IDAOGrille;

@Controller
public class JeuController {
	
	@Autowired
	private IDAOCarte daoCarte ;
	
	@Autowired
	private IDAOCase daoCase ;
	
	@Autowired
	private IDAOGrille daoGrille ;
	
	Grille maGrille = null;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping(value="/jeu")
	public String jeuAfficher(Model model, HttpSession session) {
	
		List <Carte> mesCartes = daoCarte.findAll();
		maGrille = new Grille() ;

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
		
		int scoreRouge = 0 ;
		int scoreBleu = 0 ;
		
		model.addAttribute("scoreRouge", scoreRouge);
		model.addAttribute("scoreBleu", scoreBleu);
		model.addAttribute("maGrille", maGrille);
//		Utilisateur user = (Utilisateur) session.getAttribute("monUtilisateur");
//		model.addAttribute("user", user);
		return "jeu";
	
	}
	
//		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
		@PostMapping(value="/jeu")
		@ResponseBody
		public String recupCarte(@RequestParam String nomCase, HttpSession session, Model model) {
			Case cCase = daoCase.findByCarteLibelle(nomCase, maGrille.getId());
			String couleur = String.valueOf(cCase.getCouleur());
//			Utilisateur user = (Utilisateur) session.getAttribute("monUtilisateur");
//			String name = user.getUsername();
//			System.out.println("Le joueur " + name + " a cliqué sur " + cCase.getCarte().getLibelle() + " dont la couleur est " + cCase.getCouleur());
			
			return couleur ;
		}
	
		
	

}