// Animation de démarrage

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



// Transition pour révéler les cartes et récupérer le mot côté Controller
$('#grille > div').bind('click', function() {

	var cCase=$(this).find('span').text(); //récupère le mot de la carte dans la case cliquée
	var that = $(this);


	$.ajax({ // pour renvoyer le mot au Controller
		   type: "POST",
		   //dataType : 'json',
		   url: "/jeu",
		   data: { "nomCase": cCase },
		   success : function(couleur){ //pour révéler les cartes en récupérant la couleur via la Controller
			var texte = $(that).find('span').text();

			var monTexte = $('<h5> Le joueur a cliqué sur </h5>');

			monTexte.append(texte);
			$('section#infos').append(monTexte);

			var monTexte2 = $('<h5> Et la couleur est... : </h5>');
			monTexte2.append(couleur);
			$('section#infos').append(monTexte2);

			var couleurNoire = "NOIRE" ;
			if (couleur == couleurNoire){
				var monTexte3 = $('<h5> Dommage... vous avez perdu </h5>');
				$('section#infos').append(monTexte3);
			}

			that.addClass(couleur);
			that.addClass('reveal');
			}
		});
});



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
			maDiv.append(monSpanHeure);
			maDiv.append(monJoueur);
			maDiv.append(monSpan);
			$('div#chatHist').append(maDivVide);
			$('div#chatHist').append(maDiv);
			$(this).val("");

	  }

}
