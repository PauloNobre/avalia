var map;
function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : -4.968856,
			lng : -39.014950
		},
		zoom : 16,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
}

$(document).ready(
	function(){
	$.ajax({
		url: "https://maps.googleapis.com/maps/api/js?key=AIzaSyC9OK9jV5lZTkUKu16gfhDIraFE66ScCzk&sensor=false&callback=initMap",
		dataType: "script",
		async: true
	}).done(function() {
		$.ajax({
			type : "GET",
			url : "../getEstabelecimentos",
			success : function(estabelecimentos) {
				$.each(estabelecimentos, function(index, estabelecimento) {

					console.log(estabelecimento);
					var marker = new google.maps.Marker({
						position : new google.maps.LatLng(
								estabelecimento.coordenada.latitude,
								estabelecimento.coordenada.longitude),
						title : estabelecimento.nome,
						map : map
					});

					var infowindow = new google.maps.InfoWindow({
						content : estabelecimento.nome
					});

					google.maps.event.addListener(marker, 'click',
							function() {
								infowindow.open(map, marker);
							});
				});
			},
			error : function() {
				alert('Error occured');
			}
		});
	});
})