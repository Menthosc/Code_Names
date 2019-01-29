//// Créer le tableau de carte sur la page 
//
//function listerCarte(toto) {
//
//	var maLigne = $("<tr />");
//	var macolonne1 = $("<td />");
//	macolonne1.html($('table tbody tr').length + 1);
//
//	var macolonne2 = $("<td />");
//	macolonne2.html(toto.libelle);
//
//	maLigne.append(macolonne1);
//	maLigne.append(macolonne2);
//
//	$('table tbody').append(maLigne);
//
//}
//
//// Recupérer la liste de carte du serveur
//
//function rafraichir() {
//
//	$.ajax({
//		method : 'GET',
//		url : 'http://192.168.1.110/codenames-ajax/carte',
//		success : function(tableauDeCarte) {
//
//			// console.log(tableauDeCarte)
//$('table tbody tr').remove();
//			tableauDeCarte.forEach(function(el) {
//
//				
//				listerCarte(el);
//				listerCarteMenu(el);
//
//			});
//
//		}
//	});
//
//}
//
//
//
//// Ajouter une carte
//var maCarte;
//
//function ajouterProduit() {
//
//	maCarte = {
//		libelle : $('input[name="mot"]').val(),
//	}
//
//	$.ajax({
//		contentType : "application/json",
//		method : 'POST',
//		url : 'http://192.168.1.110/codenames-ajax/carte',
//		data : JSON.stringify(maCarte),
//		success : function(carte) { // Permet de vérifier que le produit a bien
//			// été
//			// envoyé en le récupérant dans le tableau
//			rafraichir();
//		}
//	});
//}
//
//
//
//// Lister carte dans les menus déroulants
//
//function listerCarteMenu(toto) {
//	var monOption1 = $("<option />");
//	var monOption2 = $("<option />");
//	monOption1.html(toto.libelle);
//	monOption1.val(toto.id);
//	monOption2.html(toto.libelle);
//	monOption2.val(toto.id);
//
//	$('select[id = "carteASupprimer"]').append(monOption1);
//	$('select[id = "carteExistante"]').append(monOption2);
//}
//
//// Supprimer une carte
//
//function supprimerCarte() {
//	maCarte = {
//		id : $('select[id = "carteASupprimer"]').val(),
//	}
//
//	$.ajax({
//		contentType : "application/json",
//		method : 'DELETE',
//		url : 'http://192.168.1.110/codenames-ajax/carte/' + maCarte.id,
//		success : function(carte) { // Permet de vérifier que le produit a bien
//			// été
//			// envoyé en le récupérant dans le tableau
//			rafraichir();
//
//		}
//	});
//}
//
//// Modifier une carte
//
//function modifierCarte() {
//
//	maCarte = {
//		id : $('select[id = "carteExistante"]').val(),
//		libelle : $('input[id = "nouveauMot"]').val(),
//	}
//
//	$.ajax({
//		contentType : "application/json",
//		method : 'PUT',
//		url : 'http://192.168.1.110/codenames-ajax/carte/' + maCarte.id,
//		data : JSON.stringify(maCarte),
//		success : function(carte) { // Permet de vérifier que le produit a bien
//			// été
//			// envoyé en le récupérant dans le tableau
//			rafraichir();
//		}
//	});
//
//}
//
//
//rafraichir();
