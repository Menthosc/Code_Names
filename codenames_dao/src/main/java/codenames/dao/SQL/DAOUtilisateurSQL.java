package codenames.dao.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import codenames.model.Administrateur;
import codenames.model.Joueur;
import codenames.model.Utilisateur;
import codenames_dao.IDAOUtilisateur;

public class DAOUtilisateurSQL extends DAOSQL implements IDAOUtilisateur {

//	 Création d'une méthode permettant de mapper la récupération de données d'un ou plusieurs utilisateurs de la base de données
	public Utilisateur map(ResultSet result) throws SQLException {

		Utilisateur u = null;

		if (result.getObject("JOU_ID", Integer.class) != null) {
			u = new Joueur();
		}

		else {
			u = new Administrateur();
		}

		u.setId(result.getInt("UTI_ID"));
		u.setUsername(result.getString("UTI_USERNAME"));
		u.setNom(result.getString("UTI_NOM"));
		u.setPassword(result.getString("UTI_PASSWORD"));
		u.setPrenom(result.getString("UTI_PRENOM"));

		return u;
	}

//	 Création d'une méthode permettant de trouver tous les utilisateurs dans la base de données
	public List<Utilisateur> findAll() {
		List<Utilisateur> mesUtilisateurs = new ArrayList<Utilisateur>();
		try {
			this.connect();

			Statement myStatement = this.connection.createStatement();
			ResultSet myResult = ((java.sql.Statement) myStatement).executeQuery("SELECT * FROM utilisateurs");

			while (myResult.next()) {
				Utilisateur u = this.map(myResult);
				mesUtilisateurs.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // permet de retourner le numéro de l'exception SQL en cas d'erreur
		}

		return mesUtilisateurs;
	}

//	 Création d'une méthode permettant de trouver un utilisateur correspondant à un certain identifiant
	public Utilisateur findById(int id) {
		Utilisateur user = null;
		try {
			this.connect();

			PreparedStatement myStatement = this.connection.prepareStatement(
					"SELECT * FROM utilisateurs u LEFT JOIN joueurs j ON j.JOU_ID = u.UTI_ID WHERE UTI_ID = ? ");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {
				user = this.map(myResult);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

//	Création d'une méthode permettant d'ajouter ou de modifier un utilisateur (username, password, nom et prénom) et de le sauvegarder dans la base de données

	public Utilisateur save(Utilisateur u) {
		try {
			this.connect();

			String myQuery = "";

			int id = u.getId();
//            On va vérifier si l'ID de l'user à ajouter est nul ou pas
//            pour savoir si on est dans le cas d'un nouvel user
//            ou si l'user a déjà été entré dans la base de données auquel cas il a déjà un ID

			if (u.getId() == 0) {
//            On est dans le cas d'un ajout
				myQuery = "INSERT INTO utilisateurs (UTI_NOM, UTI_PRENOM, UTI_USERNAME, UTI_PASSWORD) VALUES (?, ?, ?, ?)";
			}

			else {
//                On est dans le cas d'une modification
				myQuery = "UPDATE utilisateurs SET UTI_NOM = ?, UTI_PRENOM= ?, UTI_USERNAME = ?, UTI_PASSWORD = ? WHERE UTI_ID = "
						+ id;
			}

//            On récupère la requête myQuery et on exécute la modif ou l'ajout en fonction de celle-ci
			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
			myStatement.setString(1, u.getNom());
			myStatement.setString(2, u.getPrenom());
			myStatement.setString(3, u.getUsername());
			myStatement.setString(4, u.getPassword());
			myStatement.execute();

//            Il faut maintenant créer le joueur correspondant à l'utilisateur, avec le même ID et le pseudo correspondant à l'username et banni =  false par défaut

			Utilisateur user2 = new Utilisateur();

			if (u instanceof Joueur) {
				// On est dans le cas d'une modification du joueur
				myQuery = "UPDATE joueurs SET JOU_ID = ?, JOU_PSEUDO= ?, JOU_BANNI = ?  WHERE JOU_ID = " + id;
				
				
			}
			

			else {
//                On est dans le cas d'un ajout du joueur
				// ON RECUPERE LE DERNIER ID de l'utilisateur qu'on vient de créer
				Statement myStatementID = this.connection.createStatement();
				ResultSet myResultID = ((java.sql.Statement) myStatementID)
						.executeQuery("SELECT UTI_ID FROM utilisateurs ORDER BY UTI_ID DESC LIMIT 1");

//                int userID = myResultID.getObject(1, Integer.class);
				if (myResultID.next()) {
					int userID = myResultID.getInt(1);
					user2 = findById(userID);

					myQuery = "INSERT INTO joueurs (JOU_ID, JOU_PSEUDO, JOU_BANNI) VALUES (?, ?,?)";
				}
			}
//                            
//            On récupère la requête myQuery et on exécute la modif ou l'ajout en fonction de celle-ci
			PreparedStatement myStatement2 = this.connection.prepareStatement(myQuery);
			myStatement2.setInt(1, user2.getId());
			myStatement2.setString(2, user2.getUsername());
			myStatement2.setBoolean(3, false);
			myStatement2.execute();

			
			
			
			
			
			
			
			if (u instanceof Administrateur) {

				myQuery = "INSERT INTO  administrateurs ADM_ID values (" + id + ")";
				PreparedStatement myStatement3 = this.connection.prepareStatement(myQuery);
				myStatement3.setInt(1, user2.getId());
			}
			
			
			
			
			
			
			
			
			
			
			
			
			

		}
		

		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

//	Création d'une méthode permettant de supprimer un utilisateur présent dans la base de données en spécifiant son ID
	public void deleteById(int id) {
		try {
			this.connect();
			PreparedStatement myStatement = this.connection
					.prepareStatement("DELETE FROM utilisateurs WHERE UTI_ID = ?");
			myStatement.setInt(1, id);
			myStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	Création d'une méthode permettant de supprimer un produit présent dans la base de données en réutulisant la méthode deleteById
	public void delete(Utilisateur u) {
		try {
			this.connect();
			deleteById(u.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Utilisateur connexion(String login, String mdp) {

		List<Utilisateur> mesUtilisateurs2 = findAll();
		Utilisateur user = null;

		int j = 0;
		for (Utilisateur u : mesUtilisateurs2) {

			if (login.equals(u.getUsername()) && mdp.equals(u.getPassword())) {
				System.out.print("Vous êtes connecté");
				j = 1;
				user = u;
			}
		}

		if (j == 0) {
			System.out.print("Identifiant ou mot de passe incorrect");
		}

		return user;
	}

	public int inscription(String username) {

		List<Utilisateur> mesUtilisateurs3 = findAll();
		Utilisateur user = null;

		int j = 0;
		for (Utilisateur u : mesUtilisateurs3) {

			if (username.equals(u.getUsername())) {
				System.out.print("Erreur, login déjà existant.");
				System.out.println();
				j = 1;

			}

		}

		return j;
	}

}
