package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import codenames.model.Carte;
import codenames.model.Utilisateur;
import idao.IDAOCarte;
import idao.IDAOUtilisateur;



@Controller
public class ConnexionController {

	@Autowired
	private IDAOUtilisateur DAOUtilisateurs;

	@GetMapping("/connexion")
	public String ListerUtilisateurs(@ModelAttribute Utilisateur utilisateur, Model model) {

		List<Utilisateur> lesUtilisateurs = DAOUtilisateurs.findAll();

		model.addAttribute("lesUtilisateurs", lesUtilisateurs);
		return "connexion";

	}

	
	
	
	@PostMapping(value = "/testConnexion")
	public String connexion( @ModelAttribute  Utilisateur utilisateur, HttpSession session, Model model) {

		List<Utilisateur> lesUtilisateurs = DAOUtilisateurs.findAll();

	
		for (Utilisateur u : lesUtilisateurs) {

			if (utilisateur.getUsername().equals(u.getUsername())&& utilisateur.getPassword().equals(u.getPassword())) {
				
				session.setAttribute("monUtilisateur", utilisateur);
				model.addAttribute("monUtilisateur", utilisateur);
				return "redirect:/gestionDesCartes";

			}

		}
		
		

		String monMessage = "Identifiant et/ou MDP incorrect(s). Veuillez réessayer...";
		model.addAttribute("monMessage", monMessage);
		return "connexion";

	}
	











// DECONNEXION


	@GetMapping("/deconnexion")
	public String deconnexion(HttpSession session) {

	
		session.invalidate();
		return "redirect:/connexion";

	}






}


//METHODE INVALIDATE POUR HTTP SESSION
