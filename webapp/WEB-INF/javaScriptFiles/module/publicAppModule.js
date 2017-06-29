var app = angular.module("publicAppModule", ["ngRoute","datatables","datatables.scroller","base64","serviceModule"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/",{
		templateUrl:"/WebService/javaScriptFiles/html/publicViewPage.html"
	})
	.when("/signUp",{
		templateUrl:"/WebService/javaScriptFiles/html/signUp.html"
	})
});


