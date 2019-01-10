package idao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer> {

}
