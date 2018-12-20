package codenames.dao.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import codenames_dao.IDAOCarte;
import codenames.model.Carte;


public class DAOCarteSQL extends DAOSQL implements IDAOCarte {

	



	/// Mapping

	public Carte map(ResultSet result) throws SQLException {

		Carte c = new Carte();
		c.setId(result.getInt("CAR_ID"));
		c.setLibelle(result.getString("CAR_LIBELLE"));

		return c;

	}

	public List<Carte> findAll() {

		List<Carte> mesCartes = new ArrayList<Carte>();

		try {

			this.connect();
			java.sql.Statement myStatement = this.connection.createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM cartes");

			while (myResult.next()) {

				Carte c = this.map(myResult);
				mesCartes.add(c);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur...");

		}

		return mesCartes;

	}

	public Carte findById(int id) {

		Carte maCarte = null;

		try {
			this.connect();
			PreparedStatement myStatement = this.connection.prepareStatement("SELECT * FROM produit WHERE CAR_ID = ?");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();

			if (myResult.next()) {

				Carte c = this.map(myResult);
				maCarte = this.map(myResult);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur...");
		}

		return maCarte;

	}
	
	
	
	
	public Carte save(Carte c) {
		try {
			this.connect();

			String myQuery = "";

			int id = c.getId();

			if (c.getId() == 0) {
				myQuery = "INSERT INTO cartes (CAR_LIBELLE) VALUES (?)";
			}

			else {
				myQuery = "UPDATE cartes SET CAR_LIBELLE = ? WHERE CAR_ID = "
						+ id;
			}

			PreparedStatement myStatement = this.connection.prepareStatement(myQuery);
			myStatement.setString(1, c.getLibelle());
			myStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	
	
	
	
	
	
	public void deleteById(int id) {

		try {

			this.connect();
			PreparedStatement myStatement = this.connection.prepareStatement("DELETE FROM cartes WHERE CAR_ID = ?");

			myStatement.setInt(1, id);
			myStatement.execute();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur...");

		}

	}
	
	
	
	
	public void delete(Carte c) {

		try {

			this.connect();
			deleteById(c.getId());

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur...");

		}

	}

	
	
	
	
	
	
	
	
	
	
}
