package codenames.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import codenames.model.Message;
import codenames_dao.IDAOMessage;

public class DAOMessageJPA implements IDAOMessage {

	EntityManager em;

	public DAOMessageJPA(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public List<Message> findAll() {
		List<Message> lesMessages = em.createQuery("select m from Message m", Message.class).getResultList();
		return lesMessages;
	}

	public Message findById(int id) {
		return em.find(Message.class, id);
	}

	public Message save(Message m) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (m.getId() == 0) {
			em.persist(m);
		} else {
			return em.merge(m);
		}
		tx.commit();
		return m;
	}

	public void delete(Message m) {
		em.remove(em.merge(m));
	}

	public void deleteById(int id) {
		Message leMessage = new Message();
		leMessage.setId(id);
		this.delete(leMessage);
	}

}
