angular.module("mainApp")
.service("itemTypeService",function($http){
	var service ={
		filterdItemResults:{},
		categoryList : [
			{"categoryName" : "Electronics", "selected" : true},
			{"categoryName" : "Clothing", "selected" : false},
			{"categoryName" : "Shoes", "selected" : false},
			{"categoryName" : "Bag", "selected" : false},
			{"categoryName" : "Perfumes", "selected" : false},
			{"categoryName" : "Furniture", "selected" : false},
			{"categoryName" : "Others", "selected" : false}
		],
		
		electronicsList : [ 
	            {"subCategoryName":"Mobile","selected":false},
	            {"subCategoryName":"Laptop","selected":false},
	            {"subCategoryName":"Monitor","selected":false},
	            {"subCategoryName":"Desktop","selected":false},
	            {"subCategoryName":"Printer","selected":false},
	            {"subCategoryName":"Scanner","selected":false},
	            {"subCategoryName":"Camera","selected":false},
	            {"subCategoryName":"Bluetooth Headphone","selected":false},
	            {"subCategoryName":"Bluetooth Speaker","selected":false},
	            {"subCategoryName":"Playstation","selected":false},
	            {"subCategoryName":"X-Box","selected":false},
	            {"subCategoryName":"Computer Accessories","selected":false}
		                
		]
		
		
	}
	return service;
})