package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Carte;
import codenames.model.Grille;

public interface IDAOGrille extends JpaRepository<Grille, Integer>{

}
