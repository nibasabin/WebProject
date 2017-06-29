angular.module("mainApp")
.service("filterCriteriaService",function($http,itemTypeService){
	var service={};
	service.selectedFilterCriteria ={};
	
	service.filterCriteria = function(filterCriteria){
	return	$http.post("http://localhost:9090/WebService/service/getFilterdResults",filterCriteria);
	}
	
	service.getAllInventory = function(category){
		return	$http.post("http://localhost:9090/WebService/service/getAllInventory",category);

	}
	return service;
	
})