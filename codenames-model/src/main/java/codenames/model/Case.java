package codenames.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "cases")
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
	private Grille grilleCase;
	
	

	public Grille getGrilleCase() {
		return grilleCase;
	}
	public void setGrilleCase(Grille grilleCase) {
		this.grilleCase = grilleCase;
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
