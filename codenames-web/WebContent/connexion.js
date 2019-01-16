/**
 * Gère la connexion de l'utilisateur
 */
// Initialise un booléen de connexion
var isConnected = new Boolean(false) ;

// Récupère les données du serveur concernant les comptes des utilisateurs
	$.ajax({
		method: 'GET',
		url: '',
		contentType: "application/json",
		success: function(monTableauUtilisateur) {
			console.log(monTableauUtilisateur);
			for (let utilisateur of monTableauUtilisateur){
				verifConnexion(utilisateur) ;
			}
		}
	});
	
	// Récupère les données rentrées par l'utilisateur qui se connecte au moment où celui-ci clique sur Valider
	function connexion(utilisateur){
		var monUtilisateur ={
				username: $('input #identifiant').val(),
				password: $('input #password').val(),
	}
	
	// Compare les données rentrées par l'utilisateur qui cherchent à se connecter 
	// et les données des utilisateurs de la base de données
	function verifConnexion(utilisateur) {
		if (utilisateur.username == monUtilisateur.username && utilisateur.password == monUtilisateur.password ) {
			isConnected = true ;
			return "Vous êtes connecté";
		}
		else {
			return "Identifiant ou mot de passe incorrect - Réessayer";
		}
	};
	}	
