package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Carte;
import codenames.model.Partie;

public interface IDAOPartie extends JpaRepository<Partie, Integer>{

}
