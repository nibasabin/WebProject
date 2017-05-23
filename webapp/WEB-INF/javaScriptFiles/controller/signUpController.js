angular.module("sighUpModule",[])
.controller("signUpController",function($scope,signUpService){

	$scope.createUser= function(user){
		if(user.password != user.confirmPassword){
			document.getElementById("passwordErrorMsg").innerHTML = " Please Confirm your Both password matches";
		}else{
			document.getElementById("passwordErrorMsg").innerHTML = "";
			signUpService.addUser(user);
			$scope.user={};
			
		}
			
	}

});