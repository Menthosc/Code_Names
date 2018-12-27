package codenames.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "grilles")

public class Grille {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="GRI_ID")
	private int id;
	
	@OneToMany(mappedBy="grilleCase")
	private List<Case> casesGrille;
	
	@Column(name="GRI_DIFFICULTE")
	private Difficulte difficulte;
	
	
	@OneToMany(mappedBy="grille")
	private List<Partie> lesParties;
	
	
	
	

	public List<Partie> getLesParties() {
		return lesParties;
	}
	public void setLesParties(List<Partie> lesParties) {
		this.lesParties = lesParties;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Case> getCasesGrille() {
		return casesGrille;
	}
	public void setCasesGrille(List<Case> casesGrille) {
		this.casesGrille = casesGrille;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	
	
	
	
	
	
//	public static Grille creerGrille(ArrayList<Case> cases , Difficulte d) {
//		Grille g = new Grille() ;
//		g.setCasesGrille(cases);
//		g.setDifficulte(d);
//		return g ;
//	}
	
	
	
	
	
	
	
	
	

}
