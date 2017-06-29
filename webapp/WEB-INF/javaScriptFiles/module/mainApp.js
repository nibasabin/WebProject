var app = angular.module("mainApp", ["ngRoute","datatables","datatables.scroller","base64"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/",{
		templateUrl:"/WebService/javaScriptFiles/html/commonHomePage.html"
	})
	.when("/addInventory",{
		templateUrl:"../javaScriptFiles/html/addInventory.html"
		//controller: "addInventoryController"
	})
    .when("/red", {
        templateUrl : "../javaScriptFiles/html/red.html"
    })
    .when("/signUp",{
    	templateUrl :"/WebService/javaScriptFiles/html/signUp.html"
    })
});