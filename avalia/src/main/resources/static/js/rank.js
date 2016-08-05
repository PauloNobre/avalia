$(document).ready(function() {
	$("#formEstabelecimento").hide();
	
	$("#novoEstabelecimento").on("click", function() {
		$("#formEstabelecimento").show();
	});
	
	$("#cancelar").on("click", function() {
		$("#formEstabelecimento").hide();
	});
	
	("#table-estabelecimentos").DataTable();
})