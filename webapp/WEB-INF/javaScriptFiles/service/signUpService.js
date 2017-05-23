angular.module("sighUpModule")
.service("signUpService",function($http){
	var service ={};
	service.addUser = function (userInfo){
		$http.post("http://localhost:9090/WebService/signUp",userInfo).then(function(response){
			if(response.data == 200 & response.status==200){
				alert("user registered successfully");
			}
		});
	}

return service;	
})