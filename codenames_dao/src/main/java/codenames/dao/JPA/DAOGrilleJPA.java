package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Case;
import codenames.model.Grille;
import codenames_dao.IDAOGrille;

public class DAOGrilleJPA implements IDAOGrille{
	EntityManager em ;

		
		public DAOGrilleJPA(EntityManagerFactory emf) {
			em = emf.createEntityManager();
		}
		
		public List<Grille> findAll() {
			List<Grille> mesGrilles = em.createQuery("select g from Grille g", Grille.class).getResultList();
			return mesGrilles;
		}
		
		public Grille findById(int id) {
			return em.find(Grille.class, id);
		}
		
		public Grille save(Grille g) {
			EntityTransaction tx = em.getTransaction(); 
			tx.begin();
			if (g.getId() == 0) {
				em.persist(g);
			}
			else {
				return em.merge(g);
			}
			tx.commit(); 
			return g ;
		}
		
		public void delete(Grille g) {
			EntityTransaction tx = em.getTransaction(); 
			tx.begin();
			em.remove(em.merge(g));
			tx.commit(); 
		}
	
		
		
		public void deleteById(int id) {
			Grille maGrille = new Grille();
			maGrille.setId(id);
			this.delete(maGrille);
		}
		
		
		
		
		
	
		
		
		
		
		
		
}
