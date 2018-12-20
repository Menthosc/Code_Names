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

//	 Cr�ation d'une m�thode permettant de mapper la r�cup�ration de donn�es d'un ou plusieurs utilisateurs de la base de donn�es
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

//	 Cr�ation d'une m�thode permettant de trouver tous les utilisateurs dans la base de donn�es
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
			e.printStackTrace(); // permet de retourner le num�ro de l'exception SQL en cas d'erreur
		}

		return mesUtilisateurs;
	}

//	 Cr�ation d'une m�thode permettant de trouver un utilisateur correspondant � un certain identifiant
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

//	Cr�ation d'une m�thode permettant d'ajouter ou de modifier un utilisateur (username, password, nom et pr�nom) et de le sauvegarder dans la base de donn�es

	public Utilisateur save(Utilisateur u) {
		try {
			this.connect();

			String myQuery = "";

			int id = u.getId();
//            On va v�rifier si l'ID de l'user � ajouter est nul ou pas
//            pour savoir si on est dans le cas d'un nouvel user
//            ou si l'user a d�j� �t� entr� dans la base de donn�es auquel cas il a d�j� un ID

			if (u.getId() == 0) {
//            On est dans le cas d'un ajout
				myQuery = "INSERT INTO utilisateurs (UTI_NOM, UTI_PRENOM, UTI_USERNAME, UTI_PASSWORD) VALUES (?, ?, ?, ?)";
			}

			else {
//                On est dans le cas d'une modification
				myQuery = "UPDATE utilisateurs SET UTI_NOM = ?, UTI_PRENOM= ?, UTI_USERNAME = ?, UTI_PASSWORD = ? WHERE UTI_ID = "
						+ id;
			}

//            On r�cup�re la requ�te myQuery et on ex�cute la modif ou l'ajout en fonction de celle-ci
			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
			myStatement.setString(1, u.getNom());
			myStatement.setString(2, u.getPrenom());
			myStatement.setString(3, u.getUsername());
			myStatement.setString(4, u.getPassword());
			myStatement.execute();

//            Il faut maintenant cr�er le joueur correspondant � l'utilisateur, avec le m�me ID et le pseudo correspondant � l'username et banni =  false par d�faut

			Utilisateur user2 = new Utilisateur();

			if (u instanceof Joueur) {
				// On est dans le cas d'une modification du joueur
				myQuery = "UPDATE joueurs SET JOU_ID = ?, JOU_PSEUDO= ?, JOU_BANNI = ?  WHERE JOU_ID = " + id;
				
				
			}
			

			else {
//                On est dans le cas d'un ajout du joueur
				// ON RECUPERE LE DERNIER ID de l'utilisateur qu'on vient de cr�er
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
//            On r�cup�re la requ�te myQuery et on ex�cute la modif ou l'ajout en fonction de celle-ci
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

//	Cr�ation d'une m�thode permettant de supprimer un utilisateur pr�sent dans la base de donn�es en sp�cifiant son ID
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

//	Cr�ation d'une m�thode permettant de supprimer un produit pr�sent dans la base de donn�es en r�utulisant la m�thode deleteById
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
				System.out.print("Vous �tes connect�");
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
				System.out.print("Erreur, login d�j� existant.");
				System.out.println();
				j = 1;

			}

		}

		return j;
	}

}
