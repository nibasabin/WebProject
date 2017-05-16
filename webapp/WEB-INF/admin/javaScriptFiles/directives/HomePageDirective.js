"use strict";

 angular.module("mainApp")
 .controller("homePageController",function($scope){
	$scope.addInventory = function(){
		alert("add inventory was clicked");
	};
 })
 .directive("homePageDirective",function(){
	return{
		  restrict: 'AE',
		    templateUrl: 'javaScriptFiles/html/homePage.html',
		    controller:'homePageController'
		    	
 };
});
