var ml4 = {};
ml4.opacityIn = [ 0, 1 ];
ml4.scaleIn = [ 0.2, 1 ];
ml4.scaleOut = 3;
ml4.durationIn = 800;
ml4.durationOut = 600;
ml4.delay = 500;

anime.timeline({
	loop : false
}).add({
	targets : '.ml4 .letters-1',
	opacity : ml4.opacityIn,
	scale : ml4.scaleIn,
	duration : ml4.durationIn
}).add({
	targets : '.ml4 .letters-1',
	opacity : 0,
	scale : ml4.scaleOut,
	duration : ml4.durationOut,
	easing : "easeInExpo",
	delay : ml4.delay
}).add({
	targets : '.ml4 .letters-2',
	opacity : ml4.opacityIn,
	scale : ml4.scaleIn,
	duration : ml4.durationIn
}).add({
	targets : '.ml4 .letters-2',
	opacity : 0,
	scale : ml4.scaleOut,
	duration : ml4.durationOut,
	easing : "easeInExpo",
	delay : ml4.delay
}).add({
	targets : '.ml4 .letters-3',
	opacity : ml4.opacityIn,
	scale : ml4.scaleIn,
	duration : ml4.durationIn
}).add({
	targets : '.ml4 .letters-3',
	opacity : 0,
	scale : ml4.scaleOut,
	duration : ml4.durationOut,
	easing : "easeInExpo",
	delay : ml4.delay
}).add({
	targets : '.ml4',
	opacity : 0,
	duration : 500,
	delay : 500
});

// Récupérer les cartes et les afficher dans les span des cartes

$.ajax({
	method : 'GET',
	url : 'http://192.168.1.110/codenames-ajax/carte',
	success : function(tableauDeCarte) {

		// console.log(tableauDeCarte)
		shuffle(tableauDeCarte);

		var num = 1;

		tableauDeCarte.forEach(function(el) {

			// $('span.div#grille').remove();
			// afficherCarteDansCase(el);

			var monSpan = $("<span />");
			monSpan.html(el.libelle);

			$('div#mot' + num).append(monSpan);

			num++;

		});
	}
});

// Attribuer une couleur aux cartes

var mesCouleurs = [ "blue", "blue", "blue", "blue", "blue", "blue", "blue",
		"blue", "blue", "red", "red", "red", "red", "red", "red", "red", "red",
		"black", "white", "white", "white", "white", "white", "white", "white" ];

shuffle(mesCouleurs);

mesCouleurs.forEach(function(el, i) {

	$('#mot' + (i + 1)).addClass(el);

});

$('#grille > div').bind('click', function() {
	$(this).addClass('reveal');

});

// Fonction mélange

function shuffle(array) {
	let counter = array.length;

	// While there are elements in the array
	while (counter > 0) {
		// Pick a random index
		let index = Math.floor(Math.random() * counter);

		// Decrease counter by 1
		counter--;

		// And swap the last element with it
		let temp = array[counter];
		array[counter] = array[index];
		array[index] = temp;
	}

	return array;

}

// Pour le chat

(function() {

	$('#live-chat header').on('click', function() {

		$('.chat').slideToggle(300, 'swing');
		$('.chat-message-counter').fadeToggle(300, 'swing');

	});

	$('.chat-close').on('click', function(e) {

		e.preventDefault();
		$('#live-chat').fadeOut(300);

	});

<<<<<<< Updated upstream
}) ();

$('#texte').bind('keyup', envoi);

function envoi(event){
	var x = event.keyCode;
		if (x == 13){
			var date = new Date();
			var str = date.getHours();
			str += ':'+(date.getMinutes()<10?'0':'')+date.getMinutes();
			str += ':'+(date.getSeconds()<10?'0':'')+date.getSeconds();

			var monTexte = $('<p>');
			var monSpan = $('<span>');
			var monSpanHeure = $('<span class="chat-time">');
			var maDiv = $('<div>');
			var maDivVide = $('<div container class="mt-2"></div>');
			var monHeure= str ;
			var monJoueur= $('<h5>JOUEUR</h5>');
			
			monTexte.html($(this).val());
			
			monSpan.append(monTexte);
			monSpanHeure.append(monHeure);
			maDiv.append(monJoueur);
			maDiv.append(monSpan);
			$('div#chatHist').append(maDivVide);
			$('div#chatHist').append(maDiv);
			$('div#chatHist').append(monSpanHeure);
	  }

}
