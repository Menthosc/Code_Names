package codenames.model;
import java.util.ArrayList;

public class Grille {
	
	private int id;
	private ArrayList<Case> cases = new ArrayList<Case>();
	private Difficulte difficulte;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Case> getCases() {
		return cases;
	}
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public static Grille creerGrille(ArrayList<Case> cases , Difficulte d) {
		Grille g = new Grille() ;
		g.setCases(cases);
		g.setDifficulte(d);
		return g ;
	}

}
