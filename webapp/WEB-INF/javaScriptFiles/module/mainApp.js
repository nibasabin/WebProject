var app = angular.module("mainApp", ["ngRoute","datatables","datatables.scroller"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/",{
		templateUrl:"../javaScriptFiles/html/homePage.html"
	})
	.when("/addInventory",{
		templateUrl:"../javaScriptFiles/html/addInventory.html"
		//controller: "addInventoryController"
	})
    .when("/red", {
        templateUrl : "../javaScriptFiles/html/red.html"
    })
});