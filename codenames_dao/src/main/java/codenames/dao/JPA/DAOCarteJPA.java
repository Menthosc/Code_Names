package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Carte;
import codenames_dao.IDAOCarte;

public class DAOCarteJPA implements IDAOCarte {
	EntityManager em;

	public DAOCarteJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public List<Carte> findAll() {
		List<Carte> mesCartes = em.createQuery("select c from Carte c", Carte.class).getResultList();
		return mesCartes;
	}

	public Carte findById(int id) {
		return em.find(Carte.class, id);
	}

	public Carte save(Carte c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (c.getId() == 0) {
			em.persist(c);
		} else {
			return em.merge(c);
		}
		tx.commit();
		return c;
	}

	public void delete(Carte c) {
		em.remove(em.merge(c));
	}

	public void deleteById(int id) {
		Carte maCarte = new Carte();
		maCarte.setId(id);
		this.delete(maCarte);
	}

}
