var app = angular.module("mainApp", ["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/admin",{
		templateUrl:"javaScriptFiles/html/homePage.html"
	})
	.when("/addInventory",{
		templateUrl:"javaScriptFiles/html/addInventory.html"
		//controller: "addInventoryController"
	})
    .when("/red", {
        templateUrl : "javaScriptFiles/html/red.html"
    })
});