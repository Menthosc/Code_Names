package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping("/inscription")
	public String formulaireAjout() {
		return "inscription" ;
	}
	
	@PostMapping("/inscription")
	public String ajouterUtilisateur(@ModelAttribute Utilisateur utilisateur, String passwordConfirme, Model model) {
		boolean exist = false ;
		List <Utilisateur> mesUtilisateurs = daoUtilisateur.findAll();
		for (Utilisateur u : mesUtilisateurs) {
			if (u.getUsername().equals(utilisateur.getUsername())) {
				exist = true ;
			}
		}
		
		if (exist == false && utilisateur.getPassword().equals(passwordConfirme)) {
			daoUtilisateur.save(utilisateur);
			String monMessage = "Votre inscription est confirm�e";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
		}
		
		else if (exist == true) {
			String monMessage = "Username d�j� existant. Veuillez r�essayer...";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
			
		}
		
		else if (!utilisateur.getPassword().equals(passwordConfirme)){
			String monMessage = "Les mots de passent ne correspondent pas. Veuillez r�essayer...";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
		}
		
		
		return "inscription";
		
	}
	
	
}
