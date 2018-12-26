package codenames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity

public class Carte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="CAR_ID")
	private int id;
	
	@Column(name="CAR_LIBELLE", length=50, nullable=false)
	@NotEmpty
	@NotNull
	@Size(max=50)
	private String libelle ;
	
	@OneToMany(mappedBy="carte")
	private List<Case> casesCarte ;
	
	public List<Case> getCasesCarte() {
		return casesCarte;
	}
	public void setCasesCarte(List<Case> casesCarte) {
		this.casesCarte = casesCarte;
	}
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
	
	
	
	public static Carte creerCarte(int id, String libelle, ArrayList<Carte> mesCartes) {
		
				Carte c = new Carte() ;
				c.setId(id) ;
				c.setLibelle(libelle) ;
				mesCartes.add(c);
				return c ;

	}

	
	

}
