package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Case;
import codenames_dao.IDAOCase;

public class DAOCaseJPA implements IDAOCase{
	EntityManager em ;
		
		public DAOCaseJPA(EntityManagerFactory emf) {
			em = emf.createEntityManager();
		}
		
		public List<Case> findAll() {
			List<Case> mesCases = em.createQuery("select c from Case c", Case.class).getResultList();
			return mesCases;
		}
		
		public Case findById(int id) {
			return em.find(Case.class, id);
		}
		
		public Case save(Case c) {
			EntityTransaction tx = em.getTransaction(); 
			tx.begin();
			if (c.getId() == 0) {
				em.persist(c);
			}
			else {
				return em.merge(c);
			}
			tx.commit(); 
			return c ;
		}
		
		public void delete(Case c) {
			EntityTransaction tx = em.getTransaction(); 
			tx.begin();
			em.remove(em.merge(c));
			tx.commit(); 
		}
	
		public void deleteById(int id) {
			Case maCase = new Case();
			maCase.setId(id);
			this.delete(maCase);
		}
}
