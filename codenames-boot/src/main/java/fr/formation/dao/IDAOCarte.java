package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Carte;

public interface IDAOCarte extends JpaRepository<Carte, Integer>{

}
