angular.module("mainApp")
.controller("homePageController",function($scope,itemTypeService,homePageService,DTOptionsBuilder,DTColumnBuilder,$q){

	var initialization =  function (){
		$scope.categoryList = itemTypeService.categoryList;
		$scope.electronicsList =itemTypeService.electronicsList;
		$scope.maxAmount = "";
		$scope.minAmount = "";
		$scope.newItem = true;
		$scope.usedItem = false;
		$scope.filterCriteria = {};
		$scope.filterdItemResults=itemTypeService.filterdItemResults;
 }
		initialization ();


	$scope.dtOptions = DTOptionsBuilder.fromFnPromise(function(){
		var defer = $q.defer();
		chooseUrl().then(function(result){
			defer.resolve(result.data);
		});
		return defer.promise;
	})
    .withDOM('frtip')
    .withPaginationType('full_numbers');
	
	var chooseUrl = function (){
	
		if(!$scope.isFiterCriteriaEmpty()){
			return	homePageService.getAllInventory()
		}else{
			return homePageService.filterCriteria()
			};
	
	}
	
	
	
	
	$scope.isFiterCriteriaEmpty = function (){
		var result = true;
		for( var obj in $scope.filterCriteria){
			if(obj.hasOwnProperty($scope.filterCriteria)){
				result = false;
			}
		}
		return false;
	}
	
	$scope.dtInstance={};
    $scope.dtColumns = [
                    DTColumnBuilder.newColumn('description').withTitle('Description'),
                    DTColumnBuilder.newColumn('price').withTitle('Price'),
                    DTColumnBuilder.newColumn("type").withTitle('Type')
                ];
	
	$scope.filterItem = function (filterType){
		for(var i= 0; i< $scope.categoryList.length; i++){
			if($scope.categoryList[i].categoryName == filterType){
				$scope.categoryList[i].selected = true;
			}else{
				$scope.categoryList[i].selected =false;
			}
		}
	}
	
	$scope.findCategorySelected = function(){
		var category ='';
		for(var i =0 ;i<$scope.categoryList.length; i++){
			if($scope.categoryList[i].selected == true){
				category = $scope.categoryList[i].categoryName;
				console.log("selected category was "+category);
			}
		}
		return category;
	}
	

	
	$scope.filterSearchCriteria = function(){
		var category = $scope.findCategorySelected();
		var subCategoryList = $scope.findSubCategoriesSelected();
		var minAmount = $scope.minAmount;
		var maxAmount = $scope.maxAmount;
		var newItem = $scope.newItem;
		var usedItem =$scope.usedItem;
		$scope.filterCriteria.category = category;
		$scope.filterCriteria.subCategoryList = subCategoryList;
		$scope.filterCriteria.minAmount = minAmount;
		$scope.filterCriteria.maxAmount = maxAmount;
		$scope.filterCriteria.newItem = newItem;
		$scope.filterCriteria.usedItem = usedItem;
		//homePageControllerService.filterCriteria($scope.filterCriteria);
		
		console.log($scope.filterCriteria);
	}
	

	
	$scope.findSubCategoriesSelected = function(){
		var subCategories = [ ];
		for(var i=0; i<$scope.electronicsList.length; i++){
			if($scope.electronicsList[i].selected == true){
				subCategories.push($scope.electronicsList[i].subCategoryName);
			}
		}
		return subCategories;
	}
	

	
});

