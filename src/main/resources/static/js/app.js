//Módulo principal da aplicação
var appCliente = angular.module('appCliente',['ngRoute']);	
	
	
appCliente.config(function($routeProvider,$locationProvider){
	$routeProvider
	.when('/clientes',{templateUrl : 'view/cliente.html',controller :'clienteController'})
	.when('/estados',{templateUrl : 'view/estado.html',controller :'estadoController'})
	.when('/cidades',{templateUrl : 'view/cidade.html',controller :'cidadeController'})
	.when('/clientes/:clienteId',{templateUrl :'view/clienteDetalhe.html',controller:'clienteDetalheController'})
	.otherwise({rediretTo:'/'});
	
	$locationProvider.html5Mode(true);
	
});