package codenames.java;

import codenames.dao.JPA.DAOCarteJPA;
import codenames.dao.SQL.DAOUtilisateurSQL;
import codenames.model.Carte;
import codenames.model.Case;
import codenames.model.Couleur;
import codenames.model.Grille;
import codenames.model.Joueur;
import codenames.model.Partie;
import codenames.model.Utilisateur;
import codenames_dao.IDAOUtilisateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PrincipaleCodeNames {
	
	static String lireChaine() {

		Scanner myScanner = new Scanner(System.in);
		String laChaineSaisie = myScanner.nextLine();

		if (laChaineSaisie.equals("")) {

			System.out.println("Erreur, champs vide...");

		}

		return laChaineSaisie;
	}

	static void ecrire(String a) {
		System.out.print(a);

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

	

	
	public static void main(String[] args) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Utilisation des DAO JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CodeNames");
		
		
		// Afficher toutes les cartes
		DAOCarteJPA daoCarte = new DAOCarteJPA(emf);
		List<Carte> mesCartesJPA = new ArrayList<Carte>();
		mesCartesJPA = daoCarte.findAll();
		for (Carte c : mesCartesJPA) {
			System.out.println(c.getId());
			System.out.println();
			System.out.println(c.getLibelle());
			System.out.println();	
		}
		
		
		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Utilisation des DAO SQL
		
//		public static ArrayList<Carte> mesCartes = new ArrayList<Carte>();
//		public static ArrayList<Case> mesCases = new ArrayList<Case>();
		
		
//		// Cr�ation de 10 cartes	
//		Carte table = Carte.creerCarte(0, "table", mesCartes);
//		Carte conseil = Carte.creerCarte(1, "conseil", mesCartes);
//		Carte grange = Carte.creerCarte(2, "grange", mesCartes);
//		Carte cuill�re = Carte.creerCarte(3, "cuill�re", mesCartes);
//		Carte fil = Carte.creerCarte(4, "fil", mesCartes);
//		Carte aveugle = Carte.creerCarte(5, "aveugle", mesCartes);
//		Carte payer = Carte.creerCarte(6, "payer", mesCartes);
//		Carte rouill� = Carte.creerCarte(7, "rouill�", mesCartes);
//		Carte score = Carte.creerCarte(8, "score", mesCartes);
//		Carte ananas = Carte.creerCarte(9, "ananas", mesCartes);
//		
		// Cr�ation de 4 utilisateurs et association au profil "Joueur"
//		Utilisateur u1 = Utilisateur.creerUtilisateur(0, "durand", "pierre", "pierre00", "0123");
//		Utilisateur u2 = Utilisateur.creerUtilisateur(1, "dupont", "marie", "marie00", "1234");
//		Utilisateur u3 = Utilisateur.creerUtilisateur(2, "faure", "felix", "felix00", "2345");
//		Utilisateur u4 = Utilisateur.creerUtilisateur(3, "einstein", "albert", "albert00", "3456");
//
//		ArrayList<Utilisateur> Groupe = new ArrayList<Utilisateur>();
//		Groupe.add(u1);
//		Groupe.add(u2);
//		Groupe.add(u3);
//		Groupe.add(u4);
//
//		Joueur j1 = Joueur.creerJoueur(u1.getUsername(), false);
//		Joueur j2 = Joueur.creerJoueur(u2.getUsername(), false);
//		Joueur j3 = Joueur.creerJoueur(u3.getUsername(), false);
//		Joueur j4 = Joueur.creerJoueur(u4.getUsername(), false);

//	
//		//Connexion
//		boolean isconnected = false ;
//		ecrire ("Connexion");
//		nouvelleLigne();
//		ecrire("Entrez votre login");
//		System.out.println();
//		String login = lireChaine();
//		nouvelleLigne() ;
//		ecrire("Entrez votre mot de passe");
//		System.out.println();
//		String mdp = lireChaine();
//		
//		int j = 0;
//		for (Utilisateur u : Groupe) {
//			for (int i = 0 ; i < 3; i++) {	
//				if (login.equals(u.getUsername()) && mdp.equals(u.getPassword())) {
//					ecrire("Vous �tes connect�");
//					i = 3 ;
//					j = 1 ;
//					isconnected = true ;
//				}			
//			}								
//		}
//		if (j == 0) {
//			ecrire("Identifiant ou mot de passe incorrect");
//		}
//	
//		// Menu
//		if (isconnected == true) {
//			System.out.println();
//			System.out.println();
//			ecrire ("Selectionnez une action");
//			System.out.println();
//			ecrire ("1 - Voir les cartes");
//			System.out.println();
//			ecrire ("2 - D�marrer partie");
//			System.out.println();
//			ecrire ("3 - D�connexion") ;
//			System.out.println();
//		
//			int a = lireEntier() ;{
//				if (a == 1) {
//					for (Carte c : mesCartes) {
//						System.out.println(c.getId() + "==>" + c.getLibelle());
//						System.out.println();
//					}
//				}
//				if (a == 2) {
//					
//				}
//				if (a == 3) {
//					isconnected = false ;
//				}
//			}
//		}
//		if (isconnected == false) {
//			System.out.println();
//			ecrire ("Vous �tes d�connect�");
//		}
//		
//		
//		
//		
//		
//		
//			// Cr�ation partie
//		java.util.Collections.shuffle(mesCartes);
//		
//		for (int i =  0 ; i < 25 ; i ++) {
//			Carte c = new Carte() ;
//			c = mesCartes.remove(0) ;
//			couleur.getRandomCouleur();
//			Case cs = Case.CreerCase(c, couleur, mesCases);
//		}
//	}
//
//	
//	
//	

//	
//	static void ecrire(String a) {
//		System.out.print(a);
//		
//	}
//	static void nouvelleLigne() {
//		System.out.print("\r");
//	}
//	

		// LISTER LES CARTES
		// /////////////////////////////////////////////////////////////////////

//		IDAOCarte daoCartes = new DAOCarteSQL();
//
//		List<Carte> lesCartes = daoCartes.findAll();
//
//		for (Carte c : lesCartes) {
//
//			System.out.println("------------------------");
//			System.out.println("ID" + c.getId());
//			System.out.println("Le nom = " + c.getLibelle());
//		
//

//		}

		// LISTER LES UTILISATEURS
		// /////////////////////////////////////////////////////////////////////

//		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
//
//		List<Utilisateur> lesUtilisateurs = daoUtilisateur.findAll();
//		
//				for (Utilisateur u : lesUtilisateurs) {
//		
//					System.out.println("------------------------");
//					System.out.println("ID" + u.getId());
//					System.out.println("Le nom = " + u.getNom());
//					System.out.println("Username = " + u.getUsername());
//		
//				}

//				IDAOPartie daoPartie = new DAOPartieSQL();

//				List<Partie> lesParties = daoPartie.findAll();
//		
//				for (Partie p : lesParties) {
//		
//					System.out.println("------------------------");
//					System.out.println("ID partie = " + p.getId());
//					System.out.println("Le capitaine = " + p.getCapitaine().getId());
//					System.out.println("ID grille = " + p.getGrille().getId());
//		
//				}
//		

//		
//			// CREATION UTILISATEUR ET RECHERCHE PAR ID
		// /////////////////////////////////////////////////////////////////////

//		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
//		
//		Utilisateur u1 = new Utilisateur();
//		u1.setNom("JEAN");
//	    u1.setUsername("JEANMICH");
//	    u1.setPrenom("jeaneude");
//	    u1.setPassword("tropDur");
//		
//		daoUtilisateur.save(u1);
//		
//	
//				
//				
//		System.out.println(daoUtilisateur.findById(4).getPassword());
//		System.out.println();		

		// CONNEXION UTILISATEUR
		// /////////////////////////////////////////////////////////////////////

//		System.out.println("Connexion");
//		System.out.println();
//		
//		int i = 0;
//		boolean isConnected = false;
//
//		while (isConnected == false && i < 3) {
//			
//			System.out.println();
//			System.out.println("Entrez votre login");
//			System.out.println();
//			String login = lireChaine();
//			System.out.println();
//			System.out.println("Entrez votre mot de passe");
//			System.out.println();
//			String mdp = lireChaine();
//
//			DAOUtilisateurSQL daoUtilisateur2 = new DAOUtilisateurSQL();
//
//			Utilisateur verifConnexion = daoUtilisateur2.connexion(login, mdp);
//			System.out.println();
//
//			if (verifConnexion == null) {
//				isConnected = true;
//			
//			}
//			
//			i++;
//			
//			if (i == 3) {
//				System.out.println();
//				System.out.println("Nombre de tentatives d�pass� !");
//				
//			}
//			
//			
//		}
//		

///////////////////////    CREATION DE CARTE

//      DAOCarteSQL daoNouvelleCarte = new DAOCarteSQL();
//      Carte nouvelleCarte = new Carte();
//      IDAOCarte daoCartes2 = new DAOCarteSQL() ;
//      List<Carte> listeCartes = daoCartes2.findAll();
//      
//      System.out.println("Entrez votre libell� de carte :");
//      System.out.println();
//      String libelle = lireChaine();
//      System.out.println();
//      
//      int carteExistante = 0 ;
//      
//      for (Carte c : listeCartes) {  // Permet de v�rifier si le libell� de carte est d�j� pr�sent
//          if (c.getLibelle().equals(libelle)) {
//              carteExistante = 1 ;
//          }
//      }
//      
//      if (carteExistante == 1 ){
//    	  System.out.println("Erreur! Ce libell� de carte existe d�j�");
//          System.out.println();
//      }
//      else {
//          nouvelleCarte.setLibelle(libelle);
//          daoNouvelleCarte.save(nouvelleCarte);
//      }
//      
////           SUPPRESSION DE CARTE
//      
//      System.out.println("Entrez l'ID de la carte � supprimer");
//          System.out.println();
//          int id = lireEntier();
//          System.out.println();
//          DAOCarteSQL daoCartes3 = new DAOCarteSQL() ;
//          daoCartes3.deleteById(id);
//          System.out.println("La carte ID no:" + id + " a �t� supprim�e...");

///////////////////////    INSCRIPTION

//		DAOUtilisateurSQL daoUtilisateur2 = new DAOUtilisateurSQL();
//		Utilisateur u = null;
//		int verifUsername = -1;
//
//		System.out.println("---------------------------------");
//		System.out.println("INSCRIPTION AU SERVEUR DE JEU");
//		System.out.println();
//		System.out.println("Entrez votre nom:");
//		System.out.println();
//		String nom = lireChaine();
//		System.out.println("Entrez votre pr�nom:");
//		System.out.println();
//		String prenom = lireChaine();
//
//		for (int i = 0; i < 3; i++) {
//
//			System.out.println("Entrez un Login:");
//			System.out.println();
//			String username = lireChaine();
//
//			verifUsername = daoUtilisateur2.inscription(username);
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
//						u = new Utilisateur();
//						u.setNom(nom);
//						u.setPrenom(prenom);
//						u.setUsername(username);
//						u.setPassword(mdp);
//
//						daoUtilisateur2.save(u);
//						System.out.println("Vous etes d�sormais inscrit!");
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

///////////////////////    CREATION D'UNE PARTIE

//		DAOPartieSQL daoNouvellePartie = new DAOPartieSQL();
//		Partie nouvellePartie = new Partie();
//		Joueur capitaine = new Joueur();
//		Grille grilledeJeu = new Grille();
//
//		ecrire("Entrez le num�ro de grille :");
//		System.out.println();
//		grilledeJeu.setId(lireEntier());
//		System.out.println();
//		ecrire("Entrez l'identifiant joueur pour le capitaine :");
//		System.out.println();
//		capitaine.setId(lireEntier());
//		System.out.println();
//		int isCapitaine = 0;
//
//		for (Utilisateur u : lesUtilisateurs) {
//			if (u.getId() == capitaine.getId()) {
//				try {
//					nouvellePartie.setCapitaine((Joueur) u);
//					isCapitaine = 1;
//				} catch (Exception UtilisateurEstAdmin) {
//					System.out.println("L'utilisateur ne peut pas jouer");
//				}
//			}
//		}
//
//		if (isCapitaine == 0) {
//			System.out.println();
//			ecrire("Le joueur n'existe pas, veuillez r�essayer");
//			System.out.println();
//		}
//
//		else {
//			nouvellePartie.setGrille(grilledeJeu);
//			daoNouvellePartie.save(nouvellePartie);
//			ecrire("La nouvelle partie est cr��e");
//			System.out.println();
//		}

	}

}
