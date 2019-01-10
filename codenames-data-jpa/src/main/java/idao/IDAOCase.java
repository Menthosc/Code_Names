package idao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Case;

public interface IDAOCase extends JpaRepository<Case, Integer>{

}
