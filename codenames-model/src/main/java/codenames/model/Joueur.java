package codenames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="joueurs")
@PrimaryKeyJoinColumn(name= "JOU_ID", referencedColumnName= "UTI_ID")
public class Joueur extends Utilisateur {
	
	
	@NotEmpty
	@NotNull
	@Column(name = "JOU_PSEUDO")
	private String pseudo ;
	
	@Column(name = "JOU_BANNI")
	private boolean banni;
	
	@OneToMany(mappedBy="joueur")
	private List<Participation> participations ;
	
	
	@OneToMany(mappedBy="leJoueur")
	private List<Message> Messages;
	
	
	@OneToMany(mappedBy="capitaine")
	private List<Partie> lesParties;
	
	
	
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
	



	public List<Participation> getParticipations() {
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	public List<Message> getMessages() {
		return Messages;
	}
	public void setMessages(List<Message> messages) {
		Messages = messages;
	}

	public List<Partie> getLesParties() {
		return lesParties;
	}
	public void setLesParties(List<Partie> lesParties) {
		this.lesParties = lesParties;
	}
	
	
	
//	public static Joueur creerJoueur(String pseudo, boolean banni) {
//		Joueur j = new Joueur() ;
//		j.setBanni(banni) ;
//		j.setPseudo(pseudo) ;
//		return j ;
//	}
	
	
	
	
}
