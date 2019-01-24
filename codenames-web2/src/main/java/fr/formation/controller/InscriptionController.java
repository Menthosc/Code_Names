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
	public String ajouterUtilisateur(@ModelAttribute Utilisateur utilisateur, String password, Model model) {
		boolean exist = false ;
		System.out.println(password);
		List <Utilisateur> mesUtilisateurs = daoUtilisateur.findAll();
		for (Utilisateur u : mesUtilisateurs) {
			if (u.getUsername().equals(utilisateur.getUsername())) {
				exist = true ;
			}
		}
		
		if (exist == false && utilisateur.getPassword().equals(password)) {
			daoUtilisateur.save(utilisateur);
			return "redirect:./accueil";
		}
		
		else if (exist == true) {
			System.out.println("Username déjà existant");

			
		}
		
		else if (utilisateur.getPassword() != password){
			System.out.println("Les mots de passent ne correspondent pas");

		}
		return "redirect:./inscription";
		
	}
	
	
}
