package codenames.model;

import java.util.ArrayList;


public class Carte {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	private int id;
	private String libelle;
	
	
	public static Carte creerCarte(int id, String libelle, ArrayList<Carte> mesCartes) {
		
				Carte c = new Carte() ;
				c.setId(id) ;
				c.setLibelle(libelle) ;
				mesCartes.add(c);
				return c ;

	}

	
	

}
