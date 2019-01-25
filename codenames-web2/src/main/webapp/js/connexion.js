///**
// * Gère la connexion de l'utilisateur
// */
//
//function Utilisateur(username, password){	
//}
//
//$('section').hide();
//$('section#pasConnecte').show();
//
//var isConnected = 0;
//var monUtilisateur = new Utilisateur;
//var monTableau = [];
//
////Récupère les données du serveur concernant les comptes des utilisateurs
//	$.ajax({
//		method: 'GET',
//		url: 'http://192.168.1.110/codenames-ajax/utilisateur',
//		contentType: "application/json",
//		success: function(monTableauUtilisateur) {
//			console.log(monTableauUtilisateur);
//			for (let utilisateur of monTableauUtilisateur){
//				monTableau.push(utilisateur);
//			}
//		}
//	});
//	
//// Récupère les données rentrées par l'utilisateur qui se connecte au moment où celui-ci clique sur Valider
//	function connexion(utilisateur){
//		monUtilisateur ={
//				username: $('input#identifiant').val(),
//				password: $('input#password').val(),
//		}
//		console.log(monUtilisateur);
//		
//		for (let utilisateur of monTableau){
//			verifConnexion(utilisateur, monUtilisateur) ;
//			
//			if (isConnected == 0){
//				console.log("Identifiant ou mot de passe incorrect - Veuillez reessayer");
//				$('section').hide();
//				$('section#mauvaiseConnexion').show();
//			}
//		}
//	}
//	
//// Compare les données rentrées par l'utilisateur qui cherchent à se connecter 
//// et les données des utilisateurs de la base de données
//	function verifConnexion(utilisateur, monUtilisateur) {
//		if (utilisateur.username == monUtilisateur.username && utilisateur.password == monUtilisateur.password ) {
//			console.log("Vous etes connecte");
//			isConnected = 1;
//			$('section').hide();
//			$('section#connecte').show();
//			return "Vous êtes connecte";
//		}
//	};
//		