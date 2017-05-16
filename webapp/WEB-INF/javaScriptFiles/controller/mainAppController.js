angular.module("mainApp")
.controller("mainAppController",function($scope,$http){

	$scope.logOut= function(){
		$http.get("/WebService/logout").then(function(response){
			if(response.status == 200){
				//alert("logggin off from application");
			console.log("successfully Logged off");
			}
		});
	}
	

});