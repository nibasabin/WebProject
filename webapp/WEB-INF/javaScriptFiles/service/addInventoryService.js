angular.module("mainApp")
.service("addInventoryService",function($http){
	var service ={};
	service.addInventory = function (itemObject){
		$http.post("inventory/addItem",itemObject).then(function(response){
			if(response.status == 200){
				alert("item saved successfully");
			console.log("successful");
			}
		});
	}

return service;	
})