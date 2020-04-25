
//Criação dos controllers dos clientes

appCliente.controller("clienteController",function($scope,$http){
	
	$scope.nome = "kleves";
	$scope.sobrenome = "Henrique Aguiar";
	$scope.clientes=[];
	$scope.cliente={};
	
	//metodo para carregar os clientes no scope
	carregarClientes = function(){
		$http({
			method :'GET',
			url : 'http://localhost:8080/clientes'
		})
		.then(function(response){
			$scope.clientes = response.data;  
		},function(response){
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	//$scope.carregarClientes();
	
	//método para salvar um cliente e adicionar na lista	
	$scope.salvarCliente = function(){
		if($scope.frmCliente.$valid){
			$http({
				method : "POST",
				url : "http://localhost:8080/clientes",
				data : $scope.cliente
			})
			.then(function(response){
				//$scope.clientes.push(response.data);			
				carregarClientes();
				$scope.cliente ={};
				$scope.frmCliente.$setPristine(true);
				
			},function(response){
				console.log(response.data);
				console.log(response.status);
			});
		}else{
			window.alert("Dados incorretos");
		}
	};
		
	// método para excluir o cliente 
	$scope.excluirCliente=function(cliente){
		$http({
				
			method : "DELETE",
			url : "http://localhost:8080/clientes/"+cliente.id
				
		}).then(function(response){
			var indice = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(indice,1);
		},function(response){
			console.log(response.data);
			console.log(response.status);
		});		
	};
	
	//metodo para alterar o cliente
	$scope.alterarCliente = function(cliente){
		$scope.cliente = angular.copy(cliente);
		
	};
	
	//método para cancelar a alteração do cliente
	$scope.cancelarAlteracaoCliente= function(){
		$scope.cliente={};
	};
	
	carregarClientes();
});