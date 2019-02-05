package fr.formation.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import codenames.model.ActionJoueur;
import codenames.model.Case;
import codenames.model.Grille;
import codenames.model.GrilleId;
import codenames.model.Scores;
import codenames.model.Views;
import fr.formation.controller.JeuController;
import fr.formation.dao.IDAOCase;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class JeuRestController {

	@Autowired
	private IDAOCase daoCase ;
	

	Grille grille = null ;
	
	int scoreBleu = 0 ;
	int scoreRouge = 0 ;
	Scores mesScores = null;
	
	
	@PostMapping("/case")
	public ActionJoueur action(@RequestBody ActionJoueur action) {
		return action;
	}
	
	@PostMapping("/grille")
	public GrilleId recupGrille(@RequestBody GrilleId grilleId) {
		grille = new Grille() ;
		grille.setId(grilleId.getId());
		return grilleId;
	}
	
	@JsonView(Views.Case.class)
	@GetMapping("/listeCase/{id}")
	public List<Case> listeCase(@PathVariable int id) {
		return this.daoCase.findByGrilleId(id);
	}
	

	
	@PostMapping(value="/jeu")
	public String recupCarte(@RequestParam String nomCase, @RequestBody int grilleId) {
		Case cCase = daoCase.findByCarteLibelle(nomCase, grilleId);
		String couleur = String.valueOf(cCase.getCouleur());
		
		if (couleur == "ROUGE") {
			scoreRouge = scoreRouge + 1 ;
		}
		
		if (couleur == "BLEUE") {
			scoreBleu = scoreBleu + 1 ;
		}
		
		Scores mesScores = new Scores() ;
		mesScores.setScoreBleu(scoreBleu);
		mesScores.setScoreRouge(scoreRouge);
		
//		Utilisateur user = (Utilisateur) session.getAttribute("monUtilisateur");
//		String name = user.getUsername();
//		System.out.println("Le joueur " + name + " a cliqué sur " + cCase.getCarte().getLibelle() + " dont la couleur est " + cCase.getCouleur());
		
		return couleur ;
	}
	
	
	
	@GetMapping("/scores")
	public Scores scores() {
		mesScores.setScoreBleu(mesScores.getScoreBleu());
		mesScores.setScoreRouge(mesScores.getScoreRouge());
		return mesScores ;
	}


		
	
}
