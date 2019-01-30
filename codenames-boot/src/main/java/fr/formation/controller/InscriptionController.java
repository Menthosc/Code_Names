package fr.formation.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import codenames.model.Utilisateur;
import fr.formation.dao.IDAOUtilisateur;

@Controller
public class InscriptionController {

	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@GetMapping("/inscription")
	public String formulaireAjout(Principal principal, Model model) {

		if (principal == null) {

			return "inscription";
		}

		else {
			
			String monMessage = "Vous etes déjà inscrit...";
			
			model.addAttribute("message", monMessage);
			return "accueil";

		}

	}

	
	@PostMapping("/inscription")
	public String ajouterUtilisateur(@ModelAttribute Utilisateur utilisateur, String passwordConfirme, Model model) {

		boolean exist = false;
		List<Utilisateur> mesUtilisateurs = daoUtilisateur.findAll();
		for (Utilisateur u : mesUtilisateurs) {
			if (u.getUsername().equals(utilisateur.getUsername())) {
				exist = true;
			}
		}

		if (exist == false && utilisateur.getPassword().equals(passwordConfirme)) {
			
			
			utilisateur.setPassword(bcrypt.encode(utilisateur.getPassword()));
			daoUtilisateur.save(utilisateur);
			String monMessage = "Votre inscription est confirmée !";
			System.out.println(monMessage);
			model.addAttribute("message", monMessage);
			return "accueil";
		}

		else if (exist == true) {
			String monMessage = "Username déjà existant. Veuillez réessayer...";
			System.out.println(monMessage);
			model.addAttribute("message", monMessage);
			return "accueil";

		}

		else if (!utilisateur.getPassword().equals(passwordConfirme)) {
			String monMessage = "Les mots de passent ne correspondent pas. Veuillez réessayer...";
			System.out.println(monMessage);
			model.addAttribute("message", monMessage);
			return "accueil";
		}

		return "inscription";

	}

}
