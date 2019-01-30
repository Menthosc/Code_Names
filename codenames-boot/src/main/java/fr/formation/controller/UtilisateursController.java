package fr.formation.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codenames.model.Carte;
import codenames.model.Utilisateur;
import fr.formation.dao.IDAOUtilisateur;


@Controller
public class UtilisateursController {
	
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	

	
	
	/// LISTAGE DES UTILISATEURS DANS LES MENUS DEROULANTS
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/gestionDesJoueurs")
	public String ListerCartes(@ModelAttribute Utilisateur utilisateurs, Model model) {

		List<Utilisateur> mesUtilisateurs = daoUtilisateur.findAll();

		model.addAttribute("mesUtilisateurs", mesUtilisateurs);

		return "gestionDesJoueurs";

	}
	
	
	/// MODIFICATION D'UN UTILISATEUR
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/bannirJoueur")
	public String editerProduit(@ModelAttribute Utilisateur utilisateur, Model model) {

		
//		model.addAttribute("fournisseurs", DAOcartes.findAll());
		daoUtilisateur.save(utilisateur);
		return "redirect:/gestionDesJoueurs";
		

	}
	
	
	
	
	
	
	
	
	
	

	/// SUPPRESSION D'UNE CARTE
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping({ "/supprimerJoueur" })
	public String supprimerProduit(@RequestParam int id, Model model) {

		daoUtilisateur.deleteById(id);

		return "redirect:/gestionDesJoueurs";
	}
	

	
	
	
	
	
	

}
