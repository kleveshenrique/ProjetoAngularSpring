appCliente.controller('clienteDetalheController',function($scope,$http,$routeParams){
	
	$scope.cliente={};
	$scope.titulo = "Pagina detalhe do cliente";
	
	$http({
		method : 'GET',
		url : '/clientes/'+$routeParams.clienteId
	}).then(function (response){
		$scope.cliente = response.data; 
	},function (response){
		//console.log(response);
	});
});