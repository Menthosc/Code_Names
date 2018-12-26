package codenames.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity

public class Case {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="CAS_ID")
	private int id;
	
	@Column(name="CAS_COULEUR")
	private Couleur couleur;
	
	@ManyToOne
	@JoinColumn(name="CAS_CARTES_ID")
	private Carte carte;
	
	@ManyToOne
	@JoinColumn(name="CAS_GRILLES_ID")
	private List<Grille> grilles;
	
	
	public List<Grille> getGrilles() {
		return grilles;
	}
	public void setGrilles(List<Grille> grilles) {
		this.grilles = grilles;
	}
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
