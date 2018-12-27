package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Partie;
import codenames.model.Utilisateur;
import codenames_dao.IDAOUtilisateur;

public class DAOUtilisateurJPA implements IDAOUtilisateur {
EntityManager em ;
	
	public DAOUtilisateurJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	public List<Utilisateur> findAll() {
		List<Utilisateur> mesUtilisateurs = em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
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
		}
		else {
			return em.merge(u);
		}
		tx.commit(); 
		return u ;
	}
	
	
	
	
	public void delete(Utilisateur u) {
		em.remove(em.merge(u));
	}

	public void deleteById(int id) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(id);
		this.delete(utilisateur);
	}

	
	
}
