angular.module("mainApp")
.controller("signUpController",function($scope,signUpService,$location){

	$scope.createUser= function(user){
		if(user.password != user.confirmPassword){
			document.getElementById("passwordErrorMsg").innerHTML = " Please Confirm your Both password matches";
		}else{
			document.getElementById("passwordErrorMsg").innerHTML = "";
			signUpService.addUser(user);
			$location.path("/")
			$scope.user={};
		}
	}
	
	$scope.cancelSignUp = function(){
		$location.path("/")
	}

});