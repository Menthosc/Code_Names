package fr.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import codenames.model.Utilisateur;
import idao.IDAOUtilisateur;


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
			String monMessage = "Votre inscription est confirmée";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
		}
		
		else if (exist == true) {
			String monMessage = "Username déjà existant. Veuillez réessayer...";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
			
		}
		
		else if (!utilisateur.getPassword().equals(passwordConfirme)){
			String monMessage = "Les mots de passent ne correspondent pas. Veuillez réessayer...";
			System.out.println(monMessage);
			model.addAttribute("monMessage", monMessage);
			return "inscription";
		}
		
		
		return "inscription";
		
	}
	
	
}
