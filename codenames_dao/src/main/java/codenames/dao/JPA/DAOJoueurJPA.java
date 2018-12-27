package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Joueur;
import codenames.model.Partie;
import codenames_dao.IDAO;
import codenames_dao.IDAOJoueur;

public class DAOJoueurJPA implements IDAOJoueur {

	EntityManager em;

	public DAOJoueurJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public List<Joueur> findAll() {
		List<Joueur> lesJoueurs = em.createQuery("select j from Joueur j", Joueur.class).getResultList();
		return lesJoueurs;
	}

	public Joueur findById(int id) {
		return em.find(Joueur.class, id);
	}

	public Joueur save(Joueur j) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (j.getId() == 0) {
			em.persist(j);
		} else {
			return em.merge(j);
		}
		tx.commit();
		return j;
	}

	public void delete(Joueur j) {
		em.remove(em.merge(j));
	}

	public void deleteById(int id) {
		Joueur leJoueur = new Joueur();
		leJoueur.setId(id);
		this.delete(leJoueur);
	}

}
