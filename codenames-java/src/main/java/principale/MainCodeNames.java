package principale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import codenames.model.Utilisateur;
import codenames.model.Carte;
import codenames.model.Joueur;
import codenames.model.Participation;
import codenames.model.Partie;
import codenames.model.Role;
import codenames.model.Case;
import codenames.model.Couleur;
import codenames.model.Difficulte;
import codenames.model.Grille;
import idao.IDAOCarte;
import idao.IDAOGrille;
import idao.IDAOJoueur;
import idao.IDAOParticipation;
import idao.IDAOPartie;
import idao.IDAOUtilisateur;


public class MainCodeNames {

	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	@Autowired
	IDAOCarte daoCarte;
	
	@Autowired
	IDAOJoueur daoJoueur;
	
	@Autowired
	IDAOGrille daoGrille;
	
	@Autowired
	IDAOPartie daoPartie ;
	
	@Autowired
	IDAOParticipation daoParticipation ;
	
	public void run(String[] args) {

		//Afficher les users
//		for (Utilisateur u : (daoUtilisateur.findAll())) {
//			System.out.println(u.getNom());
//
//		}
		
		// Afficher les cartes
//		for (Carte c : (daoCarte.findAll())) {
//			System.out.println(c.getId());
//			System.out.println();
//			System.out.println(c.getLibelle());
//			System.out.println();	
//		}

		
		
		
		
		
		
//		 Creation de cartes et suppression
//	
//		Carte carte = new Carte() ;
//		carte.setLibelle("Cognac");
//		daoCarte.save(carte);
//		
		
//		Carte carte2 = new Carte() ;
//		carte2.setLibelle("Voiture");
//		daoCarte.save(carte2);
//		
		
	
		
		
		
		
		//-------------------------------------------------------------------------------------------------------------------------
		
	
		// Inscription d'un utilisateur

//		Joueur u = null;
//		int verifUsername = -1;
//
//		System.out.println("---------------------------------");
//		System.out.println("INSCRIPTION AU SERVEUR DE JEU");
//		System.out.println();
//		System.out.println("Entrez votre nom:");
//		System.out.println();
//		String nom = lireChaine();
//		System.out.println("Entrez votre prenom:");
//		System.out.println();
//		String prenom = lireChaine();
//
//		for (int i = 0; i < 3; i++) {
//
//			System.out.println("Entrez un Login:");
//			System.out.println();
//			String username = lireChaine();
//
//			verifUsername = inscription(username);
//
//			for (int h = 0; h < 3; h++) {
//				if (verifUsername == 0 && !username.equals("")) {
//					i = 3;
//					System.out.println("Entrez un mot de passe:");
//					System.out.println();
//					String mdp = lireChaine();
//					System.out.println("Entrez de nouveau votre mot de passe:");
//					System.out.println();
//					String mdp2 = lireChaine();
//
//					if (mdp2.equals(mdp) && !mdp2.equals("") && !mdp2.equals("")) {
//						u = new Joueur();
//						u.setNom(nom);
//						u.setPrenom(prenom);
//						u.setUsername(username);
//						u.setPassword(mdp);
//						u.setPseudo(u.getUsername());
//						u.setBanni(false);
//						daoJoueur.save(u);
//						
//						System.out.println("Vous etes desormais inscrit!");
//						h = 3;
//
//					}
//
//				}
//
//			}
//		}
//
//		if (u == null) {
//
//			System.out.println("Nombre de tentatives maxi atteint...");
//			System.out.println();
//
//		}
		
		//-------------------------------------------------------------------------------------------------------------------------
		
		//Connexion d'un utilisateur 
		
		Joueur newJoueur = new Joueur() ;
		System.out.println("Connexion");
		System.out.println();
		
		int i = 0;
		boolean isConnected = false;

		while (isConnected == false && i < 3) {
			System.out.println("--------------");
			System.out.println();
			System.out.println("Entrez votre login");
			System.out.println();
			String login = lireChaine();
			System.out.println();
			System.out.println("Entrez votre mot de passe");
			System.out.println();
			String mdp = lireChaine();


			Utilisateur verifConnexion = connexion(login, mdp);
			System.out.println();

			if (verifConnexion != null) {
				isConnected = true;
				newJoueur = (Joueur) verifConnexion ;
	
			}
			
			i++;
			
			if (i == 3) {
				System.out.println();
				System.out.println("Nombre de tentatives depasse !");
				System.out.println("--------------");
			}
			
		}
		
		//-------------------------------------------------------------------------------------------------------------------------
		
		// Creation de 25 cases
		
			//Recuperation de 25 cartes qui ne peuvent pas etre vides
		
		List<Carte> mesCartes = daoCarte.findAll();
		for (Carte c : mesCartes) {
			if (c.getLibelle()=="") {
				mesCartes.remove(c);	
			}
		}
		
		java.util.Collections.shuffle(mesCartes);
		
		
		List<Case> mesCases = new ArrayList<Case>();
		
			//Definition du niveau de difficulte
		System.out.println("--------------");
		System.out.println();
		System.out.println("Entrez le niveau de difficulte");
		System.out.println("Entrez 1 pour FACILE");
		System.out.println("Entrez 2 pour MOYEN");
		System.out.println("Entrez 3 pour DIFFICILE");
		System.out.println();
		int diff = lireEntier();

			// Creation des cases avec couleur et carte
		for (int k = 0 ; k < 9; k++) {
			Couleur couleur = Couleur.ROUGE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < 8; k++) {
			Couleur couleur = Couleur.BLEUE;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < 8 - diff ; k++) {
			Couleur couleur = Couleur.NEUTRE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
		for (int k = 0 ; k < diff; k++) {
			Couleur couleur = Couleur.NOIRE ;
			Case newCase = new Case() ;
			Carte newCarte = mesCartes.remove(0) ;
			newCase.setCarte(newCarte);
			newCase.setCouleur(couleur);
			mesCases.add(newCase);
		}
		
			// Melanger les cartes et creer la grille
		java.util.Collections.shuffle(mesCases);
		
		Grille nouvelleGrille = new Grille() ;
		nouvelleGrille.setCasesGrille(mesCases);
		Difficulte difficulte = null ;
		
		if (diff == 1) {
			difficulte = Difficulte.FACILE ;
		}
		if (diff == 2) {
			difficulte = Difficulte.MOYEN ;
		}
		if (diff == 3) {
			difficulte = Difficulte.DIFFICILE ;
		}
		
		nouvelleGrille.setDifficulte(difficulte);
		
		for (Case c : nouvelleGrille.getCasesGrille()) {
			System.out.println(c.getCarte().getLibelle());
			System.out.println(c.getCouleur());
			System.out.println("--------------");
		}
		
		daoGrille.save(nouvelleGrille);
		
		//-------------------------------------------------------------------------------------------------------------------------
		
//		// Creation de la partie et de la participation
		Partie newPartie = new Partie() ;
		newPartie.setGrille(nouvelleGrille);
		newPartie.setCapitaine(newJoueur);
		daoPartie.save(newPartie);
		
		Participation participation = new Participation () ;
		participation.setJoueur(newJoueur);
		participation.setPartie(newPartie);
		participation.setRole(Role.ESPION);
		daoParticipation.save(participation);
		
		//-------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public int inscription(String username) {

		List<Utilisateur> mesUtilisateurs3 = daoUtilisateur.findAll();

		int j = 0;
		for (Utilisateur u : mesUtilisateurs3) {

			if (username.equals(u.getUsername())) {
				System.out.print("Erreur, login déjà existant.");
				System.out.println();
				j = 1;
			}
		}

		return j;
	}


	public Utilisateur connexion(String login, String mdp) {

		List<Utilisateur> mesUtilisateurs = daoUtilisateur.findAll();
		Utilisateur user = null;

		int j = 0;
		for (Utilisateur u : mesUtilisateurs) {

			if (login.equals(u.getUsername()) && mdp.equals(u.getPassword())) {
				System.out.println("--------------");
				System.out.print("Vous êtes connecté");
				j = 1;
				user = u;
			}
		}

		if (j == 0) {
			System.out.println("--------------");
			System.out.print("Identifiant ou mot de passe incorrect");
		}

		return user;
	}
	
	static String lireChaine() {

		Scanner myScanner = new Scanner(System.in);
		String laChaineSaisie = myScanner.nextLine();

		if (laChaineSaisie.equals("")) {

			System.out.println("Erreur, champs vide...");

		}

		return laChaineSaisie;
	}
	
	static int lireEntier() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;
		}
	}

}
