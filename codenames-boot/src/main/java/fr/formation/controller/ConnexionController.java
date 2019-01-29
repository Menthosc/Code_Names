package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codenames.model.Utilisateur;
import fr.formation.dao.IDAOUtilisateur;



@Controller
public class ConnexionController {



	@GetMapping("/connexion")
	public String home(@RequestParam(required = false) String username, Model model) {
		model.addAttribute("Utilisateur", username);
		return "connexion";

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
		
		

//		String monMessage = "Identifiant et/ou MDP incorrect(s). Veuillez r�essayer...";
//		model.addAttribute("monMessage", monMessage);
//		return "connexion";
//
//	}
//	











// DECONNEXION


	@GetMapping("/deconnexion")
	public String deconnexion(HttpSession session) {

	
		session.invalidate();
		return "redirect:/connexion";

	}




	
	
	
	
//	@GetMapping({ "/login" })
//	public String home(@RequestParam(required = false, defaultValue = "Albert") String username, Model model) {
//		model.addAttribute("Utilisateur", username);
//		return "login";
//
//	}
//	
	
	
	
	
	


}


