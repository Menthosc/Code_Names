package idao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Participation;

public interface IDAOParticipation extends JpaRepository<Participation, Integer>{

}
