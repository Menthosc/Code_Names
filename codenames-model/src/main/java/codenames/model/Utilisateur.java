package codenames.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	protected int id;

	@NotEmpty
	@NotNull
	@Column(name = "UTI_NOM")
	protected String nom;

	@NotEmpty
	@NotNull
	@Column(name = "UTI_PRENOM")
	protected String prenom;

	@NotEmpty
	@NotNull
	@Column(name = "UTI_USERNAME")
	protected String username;

	@NotEmpty
	@NotNull
	@Column(name = "UTI_PASSWORD")
	protected String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	

//	public static Utilisateur creerUtilisateur(int id, String nom, String prenom, String username, String password) {
//		Utilisateur u = new Utilisateur();
//		u.setId(id);
//		u.setNom(nom);
//		u.setPrenom(prenom);
//		u.setUsername(username);
//		u.setPassword(password);
//		return u;

//	}

	
}
