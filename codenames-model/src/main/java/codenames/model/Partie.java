package codenames.model;

import java.util.ArrayList;



public class Partie {
	private int id ;
	private Grille grille ;
	private Joueur capitaine ;
	private ArrayList<Message> Messages = new ArrayList<Message>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Grille getGrille() {
		return grille;
	}
	public void setGrille(Grille grille) {
		this.grille = grille;
	}
	public Joueur getCapitaine() {
		return capitaine;
	}
	public void setCapitaine(Joueur capitaine) {
		this.capitaine = capitaine;
	}
	public ArrayList<Message> getMessages() {
		return Messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		Messages = messages;
	}
}
