//Módulo principal da aplicação
var appCliente = angular.module("appCliente",[]);


//Criação dos controllers

appCliente.controller("indexController",function($scope,$http){
	
	$scope.nome = "kleves";
	$scope.sobrenome = "Henrique Aguiar";
	$scope.clientes=[];
	
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
	
	
});