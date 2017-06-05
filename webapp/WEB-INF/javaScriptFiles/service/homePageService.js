angular.module("mainApp")
.service("homePageService",function($http,itemTypeService){
	var service={};
	
	service.filterCriteria = function(filterCriteria){
		$http.post("http://localhost:9090/WebService/service/getFilterdResults",filterCriteria).then(function(response){
			if(response.status == 200){
				itemTypeService.filterdItemResults = response.data;
				console.log("giving filtered results");
			}
		})
		return itemTypeService.filterdItemResults;
	}
	
	service.getAllInventory = function(){
		return	$http.get("http://localhost:9090/WebService/service/getAllInventory");

	}
	return service;
	
})