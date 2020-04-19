//Módulo principal da aplicação
var appCliente = angular.module("appCliente",[]);


//Criação dos controllers

appCliente.controller("indexController",function($scope,$http){
	
	$scope.nome = "kleves";
	$scope.sobrenome = "Henrique Aguiar";
	$scope.clientes=[];
	$scope.cliente={};
	
	//metodo para carregar os clientes no scope
	$scope.carregarClientes = function(){
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
	}
	
	//$scope.carregarClientes();
	
	//método para salvar um cliente e adicionar na lista	
	$scope.salvarCliente = function(){
		
		$http({
			method : "POST",
			url : "http://localhost:8080/clientes",
			data : $scope.cliente
		})
		.then(function(response){
			$scope.clientes.push(response.data);
			$scope.cliente.nome="";
			
		},function(response){
			console.log(response.data);
			console.log(response.status);
		});
		
		// método parqa excluir o cliente 
		$scope.excluirCliente=function(cliente){
			$http({
				
				method : "DELETE",
				url : "http://localhost:8080/clientes/"+cliente.id,
				
			}).then(function(){
				var indice = $scope.clientes.indexOf(cliente);
				$scope.clientes.splice(indice,1);
			},function(){
				
			});
		}
		
	}
	
	
});