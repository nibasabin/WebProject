angular.module("mainApp")
.service("homePageService",function($http,itemTypeService){
	var service={};
	service.selectedFilterCriteria ={};
	
	service.filterCriteria = function(filterCriteria){
	return	$http.post("http://localhost:9090/WebService/service/getFilterdResults",filterCriteria);
//			if(response.status == 200){
//				itemTypeService.filterdItemResults = response.data;
//				console.log("giving filtered results");
//			}
//		})
//		return itemTypeService.filterdItemResults;
	}
	
	service.getAllInventory = function(){
		return	$http.get("http://localhost:9090/WebService/service/getAllInventory");

	}
	return service;
	
})