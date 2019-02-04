package fr.formation.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codenames.model.Utilisateur;
import fr.formation.dao.IDAOUtilisateur;
import fr.formation.security.UtilisateurPrincipal;

@Controller
public class ConnexionController {

	
	
	@GetMapping("/connexion")
	public String home(@RequestParam(required = false) String username, Principal principal, Model model) {
		
		if (principal == null) {
			model.addAttribute("Utilisateur", username);
			return "connexion";
			
		}
		
		else {
			String monMessage = "Vous etes déjà connecté...";
			model.addAttribute("message", monMessage);
			return "accueil";
		}
		
	}

//	@PostMapping(value = "/testConnexion")
//	public String connexion( @ModelAttribute  Utilisateur utilisateur, HttpSession session, Model model) {
//
//		List<Utilisateur> lesUtilisateurs = DAOUtilisateurs.findAll();
//
//	
//		for (Utilisateur u : lesUtilisateurs) {
//
//			if (utilisateur.getUsername().equals(u.getUsername())&& utilisateur.getPassword().equals(u.getPassword())) {
//				
//				session.setAttribute("monUtilisateur", utilisateur);
//				model.addAttribute("monUtilisateur", utilisateur);
//				return "redirect:/gestionDesCartes";
//
//			}
//
//		}

//		String monMessage = "Identifiant et/ou MDP incorrect(s). Veuillez réessayer...";
//		model.addAttribute("monMessage", monMessage);
//		return "connexion";
//
//	}
//	

	
	
	
// DECONNEXION

	
	@GetMapping("/deconnexion")
	public String deconnexion(HttpSession session, Model model) {

		session.invalidate();
		
		
		String monMessage = "Vous etes bien déconnecté...";
		
		model.addAttribute("message", monMessage);
		return "redirect:/accueil";
//		return "accueil";
		
		

	}

	


}
