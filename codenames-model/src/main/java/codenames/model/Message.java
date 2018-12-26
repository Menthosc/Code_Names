package codenames.model;

import java.util.ArrayList;

import javax.persistence.*;


public class Message {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="MES_ID")
	private int id ;
	
	@Column(name="MES_PARTIES_ID")
	private Partie partie ;
	
	@Column(name="MES_JOUEURS_ID")
	private Joueur joueur ;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
	@ManyToOne
	@JoinColumn(name="MES_PARTIES_ID")
	private Partie laPartie;

	@ManyToOne
	@JoinColumn(name="MES_JOUEURS_ID")
	private Partie leJoueur;

	
	
	
}
