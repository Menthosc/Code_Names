package principale;

import org.springframework.beans.factory.annotation.Autowired;

import codenames.model.Utilisateur;
import idao.IDAOUtilisateur;


public class MainCodeNames {

	@Autowired
	IDAOUtilisateur DAO;

	public void run(String[] args) {

		for (Utilisateur u : (DAO.findAll())) {
			System.out.println(u.getNom());

		}
	}
}
