// Créer le tableau de carte sur la page 

function listerCarte(toto) {

	var maLigne = $("<tr />");
	var macolonne1 = $("<td />");
	macolonne1.html($('table tbody tr').length + 1);

	var macolonne2 = $("<td />");
	macolonne2.html(toto.libelle);

	maLigne.append(macolonne1);
	maLigne.append(macolonne2);

	$('table tbody').append(maLigne);

}

// Recupérer la liste de carte du serveur

$.ajax({
	method : 'GET',
	url : 'http://192.168.1.110/codenames-ajax/carte',
	success : function(tableauDeCarte) {
		
		// console.log(tableauDeCarte)

		tableauDeCarte.forEach(function(el) {

			listerCarte(el);
		});

	}
});

// Ajouter une carte
var maCarte;

function ajouterProduit() {

	maCarte = {
		libelle : $('input[name="mot"]').val(),
	}

	$.ajax({
		contentType : "application/json",
		method : 'POST',
		url : 'http://192.168.1.110/codenames-ajax/carte',
		data : JSON.stringify(maCarte),
		success : function(carte) { // Permet de vérifier que le produit a bien été
			// envoyé en le récupérant dans le tableau
			listerCarte(carte);
		}
	});
}


//Supprimer une carte


var maCarteASupprimer;

function supprimerCarte() {

	maCarte = {
		libelle : $('input[name="mot"]').val(),
	}

	$.ajax({
		contentType : "application/json",
		method : 'POST',
		url : 'http://192.168.1.110/codenames-ajax/carte',
		data : JSON.stringify(maCarte),
		success : function(carte) { // Permet de vérifier que le produit a bien été
			// envoyé en le récupérant dans le tableau
			listerCarte(carte);
		}
	});
}





		var monOption = $("<option />");
		
		
		
			monOption.appendselect[id="carteASupprimer"];  

			tableauDeCarte.forEach(function(el) {

				listerCarte(el);
			});


			
			
			



