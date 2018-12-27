package codenames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="parties")
public class Partie {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAR_ID")
	private int id ;
	
	@NotEmpty
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PAR_GRILLE_ID")
	private Grille grille ;
	
	@NotEmpty
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PAR_CAPITAINE")
	private Joueur capitaine ;
	
	
	@OneToMany(mappedBy="partie")
	private List<Participation> lesParticipations;

	
	
	@OneToMany(mappedBy="laPartie")
	private ArrayList<Message> Messages = new ArrayList<Message>();

	
	public List<Participation> getLesParticipations() {
		return lesParticipations;
	}
	public void setLesParticipations(List<Participation> lesParticipations) {
		this.lesParticipations = lesParticipations;
	}
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
