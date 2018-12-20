package codenames.model;

public class Utilisateur {
	protected int id ;
	protected String nom ;
	protected String prenom ;
	protected String username ;
	protected String password ;
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
	
	public static Utilisateur creerUtilisateur(int id, String nom, String prenom, String username, String password) {	
				Utilisateur u = new Utilisateur() ;
				u.setId(id);
				u.setNom(nom) ;
				u.setPrenom(prenom) ;
				u.setUsername(username) ;
				u.setPassword(password);
				return u ;
			
		}
	

}
