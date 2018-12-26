package codenames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="joueur")
@PrimaryKeyJoinColumn(name= "JOU_ID", referencedColumnName= "UTI_ID")
public class Joueur extends Utilisateur {
	
	
	@NotEmpty
	@NotNull
	@Column(name = "JOU_PSEUDO")
	private String pseudo ;
	
	@Column(name = "JOU_BANNI")
	private boolean banni;
	
	
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public boolean isBanni() {
		return banni;
	}
	public void setBanni(boolean banni) {
		this.banni = banni;
	}
	
	
	
	
	
	
	
	
//	public static Joueur creerJoueur(String pseudo, boolean banni) {
//		Joueur j = new Joueur() ;
//		j.setBanni(banni) ;
//		j.setPseudo(pseudo) ;
//		return j ;
//	}
	
	
	
	
}
