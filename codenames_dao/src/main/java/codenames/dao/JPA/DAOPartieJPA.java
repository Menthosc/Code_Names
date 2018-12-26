package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Partie;
import codenames_dao.IDAOPartie;

public class DAOPartieJPA implements IDAOPartie {
EntityManager em ;
	
	public DAOPartieJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	public List<Partie> findAll() {
		List<Partie> mesParties = em.createQuery("select p from Partie p", Partie.class).getResultList();
		return mesParties;
	}
	
	public Partie findById(int id) {
		return em.find(Partie.class, id);
	}
	
	public Partie save(Partie p) {
		EntityTransaction tx = em.getTransaction(); 
		tx.begin();
		if (p.getId() == 0) {
			em.persist(p);
		}
		else {
			return em.merge(p);
		}
		tx.commit(); 
		return p;
	}
	
	public void delete (Partie p) {
		
	}
	
	public void deleteById (int id) {
		
	}
}
