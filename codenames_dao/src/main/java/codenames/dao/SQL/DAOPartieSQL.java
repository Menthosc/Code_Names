package codenames.dao.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import codenames_dao.IDAOPartie;
import codenames.model.Partie;
import codenames.model.Utilisateur;
import codenames.model.Grille;
import codenames.model.Joueur;

public class DAOPartieSQL extends DAOSQL implements IDAOPartie {

//	 Cr�ation d'une m�thode permettant de mapper la r�cup�ration de donn�es d'une ou plusieurs parties de la base de donn�es
	public Partie map(ResultSet result) throws SQLException {
		Partie p = new Partie() ;
		
		p.setId(result.getInt("PAR_ID"));
		
//		On associe un joueur en tant que capitaine � la partie
		Joueur j = new Joueur() ;
		j.setId(result.getInt("PAR_CAPITAINE"));
		p.setCapitaine(j);
		
//		On associe la grille � la partie
		Grille g = new Grille() ;
		g.setId(result.getInt("PAR_GRILLES_ID"));
		p.setGrille(g);
		
		return p ;
	}
	
//	 Cr�ation d'une m�thode permettant de trouver toutes les parties dans la base de donn�es
	public List<Partie> findAll() {
		List<Partie> mesParties = new ArrayList<Partie>() ;
		try { 
			this.connect();
			
			Statement myStatement = this.connection.createStatement();
			ResultSet myResult = ((java.sql.Statement) myStatement).executeQuery("SELECT * FROM parties");
			
			while (myResult.next()) {
				Partie p = this.map(myResult) ;
				mesParties.add(p) ;
			}
		}
		catch (SQLException e) {
			e.printStackTrace(); // permet de retourner le num�ro de l'exception SQL en cas d'erreur
			}
		
		return mesParties ;	
	}
	
//	 Cr�ation d'une m�thode permettant de trouver une partie correspondant � un certain ID
	public Partie findById(int id) {
		Partie p = null ;
		try {
			this.connect();
			
			PreparedStatement myStatement = this.connection.prepareStatement("SELECT * FROM parties WHERE PAR_ID = ? ");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();
			
			if (myResult.next()) {
				p = this.map(myResult) ;
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		return p ;	
	}
	
//	Cr�ation d'une m�thode permettant d'ajouter ou de modifier une partie et de la sauvegarder dans la base de donn�es
	public Partie save(Partie p) {
		try {
			this.connect();		
			
			String myQuery = "";
			
			int id = p.getId() ; 
//			On va v�rifier si l'ID de la partie � ajouter est nul ou pas 
//			pour savoir si on est dans le cas d'une nouvelle partie
//			ou si la partie a d�j� �t� entr�e dans la base de donn�es auquel cas elle a d�j� un ID
			
			if (p.getId()  == 0) {
//			On est dans le cas d'un ajout
				myQuery = "INSERT INTO parties (PAR_CAPITAINE, PAR_GRILLES_ID) VALUES (?, ?)" ;
			}
			
			else {
//				On est dans le cas d'une modification 
				myQuery = "UPDATE parties SET PAR_CAPITAINE = ?, PAR_GRILLES_ID = ? WHERE PAR_ID = " + id ;
			}
			
//			On r�cup�re la requ�te myQuery et on ex�cute la modif ou l'ajout en fonction de celle-ci
			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);			
			myStatement.setInt(1, p.getGrille().getId());
			myStatement.setInt(2, p.getCapitaine().getId());
			myStatement.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return p ;
	}
	
//	Cr�ation d'une m�thode permettant de supprimer un utilisateur pr�sent dans la base de donn�es en sp�cifiant son ID
	public void deleteById(int id) {
		try {
			this.connect();			
			PreparedStatement myStatement = this.connection.prepareStatement("DELETE FROM parties WHERE PAR_ID = ?");	
				myStatement.setInt(1, id);
				myStatement.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	Cr�ation d'une m�thode permettant de supprimer un produit pr�sent dans la base de donn�es en r�utulisant la m�thode deleteById
	public void delete(Partie p) {
		try {
			this.connect();	
			deleteById(p.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}


