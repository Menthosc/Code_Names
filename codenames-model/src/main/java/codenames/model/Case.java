package codenames.model;
import java.util.ArrayList;
public class Case {
	
	
	private int id;
	private Couleur couleur;
	private Carte carte;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	public static Case CreerCase(Carte c, Couleur couleur, ArrayList<Case> mesCases) {
		Case cs = new Case() ;
		cs.setCarte(c);
		cs.setCouleur(couleur);
		mesCases.add(cs);
		return cs ;	
	}
	
}
