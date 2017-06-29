angular.module("mainApp")
.controller("commonPageController",function($scope,$compile,DTOptionsBuilder, DTColumnBuilder, $q,itemTypeService,filterCriteriaService,$base64,$route,$window){
	
	var initialization = function() {
		$scope.categoryList = itemTypeService.categoryList;
		$scope.electronicsList = itemTypeService.electronicsList;
		$scope.clothingList = itemTypeService.clothingList;
		$scope.shoesList = itemTypeService.shoesList;
		$scope.bagList = itemTypeService.bagList;
		$scope.perfumesList = itemTypeService.perfumesList;
		$scope.furnitureList = itemTypeService.furnitureList;
		$scope.otherList = itemTypeService.otherList;
		$scope.dtInstance = {};
		$scope.maxAmount = "";
		$scope.minAmount = "";
		$scope.newItem = true;
		$scope.usedItem = false;
		$scope.filterCriteria = filterCriteriaService.selectedFilterCriteria;
		
	}
	initialization();
	
	$scope.filterItem = function(filterType) {
		for (var i = 0; i < $scope.categoryList.length; i++) {
			if ($scope.categoryList[i].categoryName == filterType) {
				$scope.categoryList[i].selected = true;
			} else {
				$scope.categoryList[i].selected = false;
			}
		}
	}
	var chooseUrl = function() {

		if ($scope.isFiterCriteriaEmpty()) {
			return filterCriteriaService.getAllInventory()
		} else {
			return filterCriteriaService.filterCriteria($scope.filterCriteria)
		}
		;

	}
	
	$scope.isFiterCriteriaEmpty = function() {
		var size = $scope.sizeOfFilterCriteria();
		var result = true
		if (size > 0) {
			result = false;
		}
		return result;
	}
	
	$scope.sizeOfFilterCriteria = function() {
		var count = 0;
		var obj;

		for (obj in $scope.filterCriteria) {
			if ($scope.filterCriteria.hasOwnProperty(obj)) {
				count++;
			}
		}
		return count;
	}
	$scope.dtOptions = DTOptionsBuilder.fromFnPromise(
			function() {
				var defer = $q.defer();
				chooseUrl().then(function(result) {
					defer.resolve(result.data);
				});
				return defer.promise;
			}).withDOM('<"#domHeader"<"col-md-3" l><"col-md-8"f>><"#domBody"t><"#domFooter"<"row"ri><"row"p>> ')	

			.withPaginationType('full_numbers').withOption(
					"order", [ [ 0, 'asc' ] ])
			// .withScroller()
			.withOption("scrollY", 405)
			.withOption("lengthMenu", [ 10, 25, 50 ])
			.withOption('createdRow', function (row, data, dataIndex) {
		        $compile(angular.element(row).contents())($scope);
		    });
//			.withOption('fixedHeader',true);
//			.withOption('autoWidth',false);

	$scope.dtColumns = [
						//	DTColumnBuilder.newColumn('id').withTitle('SNo'),
						// DTColumnBuilder.newColumn('id).withTitle('No').withOption('defaultContent',''),
						//	DTColumnBuilder.newColumn('typeId').withTitle('Type Id'),
							DTColumnBuilder.newColumn(null).withTitle('Image').notSortable().withClass("dataTableImageColumn").renderWith(function(data,type,full){
								
								if (data.image == null){
									return '<img class ="dataTableImage" src ="" alt = "NO Image"/>';
								}
								else{
									
									var image = $base64.decode(data.image);
									return '<img class ="dataTableImage" src ='+image+' alt = "NO Image"/>';	
									}
								}),

							DTColumnBuilder.newColumn(null).withTitle(
									'Description').notSortable().withClass("dataTableDescriptionColumn").renderWith(function(data,type,full){
										var condition = "";
										if(data.newItem == true){
											condition = "New";
										}
										else{
											condition = "Used";
										}
										var dom = '<div class ="descriptionTable"><table>'+
													'<tr>'+
														'<td>Id :</td>'+
														'<td>'+data.id+'</td>'+
													'</tr>'+
													'<tr>'+
														'<td>Type :</td>'+
														'<td>'+data.type+'</td>'+
													'</tr>'+
													'<tr>'+
														'<td>Condition :</td>'+
														'<td>'+condition+'</td>'+
													'</tr>'+	
													'<tr>'+
													'<td>Seller :</td>'+
													'<td>'+data.sellerName+'</td>'+
												'</tr>'+
												'</table>'+
												'<div class ="descriptionBox">'+data.description+'</div></td></div>'
//												'<textarea rows="4" cols="44" readonly>'+data.description+'</textarea></td></div>'
													
											return dom;
											
									}),
							DTColumnBuilder.newColumn('price').withTitle('Price').withClass("dataTablePriceColumn"),
							DTColumnBuilder.newColumn(null).notSortable().withTitle('Add To Cart').withClass("dataTableAddToCartColumn").renderWith(function(data,type,full){
								return '<button class ="dataTableAddToCartButton">Add To Cart</button>';
							})
									];
	
	$scope.clearSearchCriteria = function() {
		$scope.maxAmount = "";
		$scope.minAmount = "";
		$scope.newItem = false;
		$scope.usedItem = false;
		
		for (var i = 0; i < $scope.electronicsList.length; i++) {
			$scope.electronicsList[i].selected = false; 
		}
		$scope.dtInstance.dataTable.fnClearTable();
	}
	
	$scope.filterSearchCriteria = function() {
		var category = $scope.findCategorySelected();
		var subCategoryList = $scope.findSubCategoriesSelected();
		var minAmount = $scope.minAmount;
		var maxAmount = $scope.maxAmount;
		var newItem = $scope.newItem;
		var usedItem = $scope.usedItem;
		if(newItem==false && usedItem ==false){
			newItem = true;
			$scope.newItem = true;
		}
		$scope.filterCriteria.category = category;
		$scope.filterCriteria.subCategoryList = subCategoryList;
		$scope.filterCriteria.minAmount = minAmount;
		$scope.filterCriteria.maxAmount = maxAmount;
		$scope.filterCriteria.newItem = newItem;
		$scope.filterCriteria.usedItem = usedItem;
		filterCriteriaService.selectedFilterCriteria = $scope.filterCriteria;
		$scope.dtInstance.rerender();
	//	$route.reload();
		console.log($scope.filterCriteria);
	}

	$scope.findCategorySelected = function() {
		var category = '';
		for (var i = 0; i < $scope.categoryList.length; i++) {
			if ($scope.categoryList[i].selected == true) {
				category = $scope.categoryList[i].categoryName;
				console
						.log("selected category was "
								+ category);
			}
		}
		return category;
	}
	
	$scope.findSubCategoriesSelected = function() {
		var subCategories = [];
		for (var i = 0; i < $scope.electronicsList.length; i++) {
			if ($scope.electronicsList[i].selected == true) {
				subCategories.push($scope.electronicsList[i].subCategoryName);
			}
		}
		return subCategories;
	}
	
	$scope.showAllItem = function(){
		$scope.filterCriteria={};
		$scope.dtInstance.rerender();
	//	$scope.dtInstance.reloadData();
	}
});
