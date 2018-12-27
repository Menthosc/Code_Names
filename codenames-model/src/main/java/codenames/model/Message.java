package codenames.model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="MES_ID")
	private int id ;
	
	@ManyToOne
	@JoinColumn(name="MES_PARTIES_ID")
	private Partie laPartie;

	@ManyToOne
	@JoinColumn(name="MES_JOUEURS_ID")
	private Joueur leJoueur;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Partie getLaPartie() {
		return laPartie;
	}

	public void setLaPartie(Partie laPartie) {
		this.laPartie = laPartie;
	}

	public Joueur getLeJoueur() {
		return leJoueur;
	}

	public void setLeJoueur(Joueur leJoueur) {
		this.leJoueur = leJoueur;
	}

	
	
}
