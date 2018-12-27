package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Participation;

public class DAOParticipationJPA {
	EntityManager em;

	public DAOParticipationJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public List<Participation> findAll() {
		List<Participation> mesParticipations = em.createQuery("select p from Participation p", Participation.class).getResultList();
		return mesParticipations;
	}

	public Participation findById(int id) {
		return em.find(Participation.class, id);
	}

	public Participation save(Participation p) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (p.getId() == 0) {
			em.persist(p);
		} else {
			return em.merge(p);
		}
		tx.commit();
		return p;
	}

	public void delete(Participation p) {
		EntityTransaction tx = em.getTransaction(); 
		tx.begin();
		em.remove(em.merge(p));
		tx.commit(); 
	}

	public void deleteById(int id) {
		Participation laParticipation = new Participation();
		laParticipation.setId(id);
		this.delete(laParticipation);
	}
}
