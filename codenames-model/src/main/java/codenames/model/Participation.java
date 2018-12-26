package codenames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participations")
public class Participation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="PTCP_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="PTCP_JOUEURS_ID")
	private Joueur joueur ;
	
	@Column(name="PTCP_ROLE")
	private Role role ;
	
	@ManyToOne
	@JoinColumn(name="PTCP_PARTIES_ID")
	private Partie partie ;
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
