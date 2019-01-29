package fr.formation.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codenames.model.Case;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class JeuRestController {

	
	@PostMapping("/case")
	public List<Integer> action(@RequestBody Integer caseId, @RequestBody Integer userId) {
		System.out.println(caseId);
		System.out.println(userId);
		List<Integer> maListe = new ArrayList<Integer>();
		maListe.add(caseId);
		maListe.add(userId);
		return maListe;
	}
	
	@PostMapping("/liste")
	public List<Case> ajout(@RequestBody List<Case> mesCases) {
		for (Case c : mesCases) {
			System.out.println(c.getCarte().getLibelle());
		}
		
		return mesCases;
	}
	
	
	
}
