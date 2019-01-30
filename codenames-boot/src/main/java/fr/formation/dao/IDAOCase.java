package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import codenames.model.Case;

public interface IDAOCase extends JpaRepository<Case, Integer>{
	
	@Query("select distinct c from Case c where c.carte.libelle = :lelibelle AND c.grilleCase.id= :grilleId")
	public Case findByCarteLibelle(@Param("lelibelle") String libelle, @Param("grilleId") int grilleId);
	
	@Query("select c from Case c where c.grilleCase.id= :grilleId")
	public List<Case> findByGrilleId(@Param("grilleId") int grilleId);
	
}
