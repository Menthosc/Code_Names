package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Joueur;
import codenames.model.Partie;
import codenames.model.Utilisateur;
import codenames_dao.IDAOUtilisateur;

public class DAOUtilisateurJPA implements IDAOUtilisateur {
	EntityManager em;

	public DAOUtilisateurJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public List<Utilisateur> findAll() {
		List<Utilisateur> mesUtilisateurs = em.createQuery("select u from Utilisateur u", Utilisateur.class)
				.getResultList();
		return mesUtilisateurs;
	}

	public Utilisateur findById(int id) {
		return em.find(Utilisateur.class, id);
	}

	public Utilisateur save(Utilisateur u) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (u.getId() == 0) {
			em.persist(u);

		} else {
			return em.merge(u);
		}
		tx.commit();
		return u;
	}

	public void delete(Utilisateur u) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
	}

	public void deleteById(int id) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(id);
		this.delete(utilisateur);
	}

	public int inscription(String username) {

		List<Utilisateur> mesUtilisateurs3 = findAll();

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

	public Utilisateur connexion(String login, String mdp) {

		List<Utilisateur> mesUtilisateurs2 = findAll();
		Utilisateur user = null;

		int j = 0;
		for (Utilisateur u : mesUtilisateurs2) {

			if (login.equals(u.getUsername()) && mdp.equals(u.getPassword())) {
				System.out.println("--------------");
				System.out.print("Vous êtes connecté");
				j = 1;
				user = u;
			}
		}

		if (j == 0) {
			System.out.println("--------------");
			System.out.print("Identifiant ou mot de passe incorrect");
		}

		return user;
	}

}
