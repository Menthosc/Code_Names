package fr.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import codenames.model.Carte;
import idao.IDAOCarte;




@Controller
public class CartesController {
	
	
	
	@Autowired
	private IDAOCarte DAOcartes;
	
	
	/// LISTAGE DES CARTES DANS LES MENUS DEROULANTS
	
	@GetMapping("/gestionDesCartes")
	public String ListerCartes(@ModelAttribute Carte cartes, Model model) {

		List<Carte> mesCartes = DAOcartes.findAll();

		model.addAttribute("mesCartes", mesCartes);

		return "gestionDesCartes";

	}
	
	
	
	
	/// AJOUT D'UNE CARTE
	
		@PostMapping("/ajouterCarte")
		public String ajouterProduit(@ModelAttribute Carte carte, Model model) {
			
			DAOcartes.save(carte);
//			return "gestionDesCartes";             // REDIRIGE VERS LA VUE SANS METHODES
			return "redirect:/gestionDesCartes";  // REDIRIGE VERS LA VUE AVEC METHODES

		
		
	}
	
	
	
	
	
	
		/// SUPPRESSION D'UNE CARTE
		
		@GetMapping({ "/supprimerCarte" })
		public String supprimerProduit(@RequestParam int id, Model model) {

			DAOcartes.deleteById(id);

			return "redirect:/gestionDesCartes";
		}
		
	
	
		
		
		
		
		
		
		
		
		
		/// MODIFICATION D'UNE CARTE
		
	


		

		@PostMapping("/modifierCarte")
		public String editerProduit(@ModelAttribute Carte carte, Model model) {

			
//			model.addAttribute("fournisseurs", DAOcartes.findAll());
			DAOcartes.save(carte);
			return "redirect:/gestionDesCartes";
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
}
