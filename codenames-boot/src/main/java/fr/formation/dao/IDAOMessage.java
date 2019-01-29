package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import codenames.model.Carte;
import codenames.model.Message;

public interface IDAOMessage extends JpaRepository<Message, Integer>{

}
