//angular
//		.module("mainApp")
//		.controller(
//				"homePageController",
//				function($scope, itemTypeService, filterCriteriaService,
//						DTOptionsBuilder, DTColumnBuilder, $q, $route,$base64) {
//
//					var initialization = function() {
//						$scope.categoryList = itemTypeService.categoryList;
//						$scope.electronicsList = itemTypeService.electronicsList;
//						$scope.maxAmount = "";
//						$scope.minAmount = "";
//						$scope.newItem = true;
//						$scope.usedItem = false;
//						$scope.filterCriteria = filterCriteriaService.selectedFilterCriteria;
//						$scope.filterdItemResults = itemTypeService.filterdItemResults;
//						$scope.dtInstance = {};
//					}
//					initialization();
//
//					$scope.dtOptions = DTOptionsBuilder.fromFnPromise(
//							function() {
//								var defer = $q.defer();
//								chooseUrl().then(function(result) {
//									defer.resolve(result.data);
//								});
//								return defer.promise;
//							}).withDOM("<row<'col-md-3'l><'col-md-8'f>>rtip")
//							.withPaginationType('full_numbers').withOption(
//									"order", [ [ 0, 'asc' ] ])
//							// .withScroller()
//							.withOption("scrollY", 405).withOption(
//									"lengthMenu", [ 10, 25, 50 ]);
//
//					var chooseUrl = function() {
//
//						if ($scope.isFiterCriteriaEmpty()) {
//							return filterCriteriaService.getAllInventory()
//						} else {
//							return filterCriteriaService.filterCriteria($scope.filterCriteria)
//						}
//						;
//
//					}
//
//					$scope.sizeOfFilterCriteria = function() {
//						var count = 0;
//						var obj;
//
//						for (obj in $scope.filterCriteria) {
//							if ($scope.filterCriteria.hasOwnProperty(obj)) {
//								count++;
//							}
//						}
//						return count;
//					}
//
//					$scope.isFiterCriteriaEmpty = function() {
//						var size = $scope.sizeOfFilterCriteria();
//						var result = true
//						if (size > 0) {
//							result = false;
//						}
//						return result;
//					}
//
//
//				
//					$scope.dtColumns = [
//						//	DTColumnBuilder.newColumn('id').withTitle('SNo'),
//						// DTColumnBuilder.newColumn('id).withTitle('No').withOption('defaultContent',''),
//						//	DTColumnBuilder.newColumn('typeId').withTitle('Type Id'),
//							DTColumnBuilder.newColumn(null).withTitle('Image').renderWith(function(data,type,full){
//								
//								if (data.image == null){
//									return '<img class ="dataTableImage" src ="" alt = "NO Image"/>';
//								}
//								else{
//									
//									var image = $base64.decode(data.image);
//									return '<img class ="dataTableImage" src ='+image+' alt = "NO Image"/>';	
//									}
//								}),
//
//							DTColumnBuilder.newColumn(null).withTitle(
//									'Description').renderWith(function(data,type,full){
//										var condition = "";
//										if(data.newItem == true){
//											condition = "New";
//										}
//										else{
//											condition = "Used";
//										}
//										var dom = '<table>'+
//													'<tr>'+
//														'<td>Type Id:</td>'+
//														'<td>'+data.typeId+'</td>'+
//													'</tr>'+
//													'<tr>'+
//														'<td>Type:</td>'+
//														'<td>'+data.type+'</td>'+
//													'</tr>'+
//													'<tr>'+
//														'<td>Condition:</td>'+
//														'<td>'+condition+'</td>'+
//													'</tr>'+
//													'<tr>'+
//														'<td>Price:</td>'+
//														'<td>$ '+data.price+'</td>'+
//													'</tr>'+	
//													'<tr>'+
//														'<td>Description:</td>'+
//														'<td>'+data.description+'</td>'+
//													'</tr>'+
//												'</table>'
//											return dom;
//											
//									}),
//							DTColumnBuilder.newColumn(null).withTitle('Add To Cart').renderWith(function(data,type,full){
//								return '<button>Add To Cart</button>';
//							})
//									];
//
//					$scope.filterItem = function(filterType) {
//						for (var i = 0; i < $scope.categoryList.length; i++) {
//							if ($scope.categoryList[i].categoryName == filterType) {
//								$scope.categoryList[i].selected = true;
//							} else {
//								$scope.categoryList[i].selected = false;
//							}
//						}
//					}
//
//					$scope.findCategorySelected = function() {
//						var category = '';
//						for (var i = 0; i < $scope.categoryList.length; i++) {
//							if ($scope.categoryList[i].selected == true) {
//								category = $scope.categoryList[i].categoryName;
//								console
//										.log("selected category was "
//												+ category);
//							}
//						}
//						return category;
//					}
//
//					$scope.filterSearchCriteria = function() {
//						var category = $scope.findCategorySelected();
//						var subCategoryList = $scope
//								.findSubCategoriesSelected();
//						var minAmount = $scope.minAmount;
//						var maxAmount = $scope.maxAmount;
//						var newItem = $scope.newItem;
//						var usedItem = $scope.usedItem;
//						$scope.filterCriteria.category = category;
//						$scope.filterCriteria.subCategoryList = subCategoryList;
//						$scope.filterCriteria.minAmount = minAmount;
//						$scope.filterCriteria.maxAmount = maxAmount;
//						$scope.filterCriteria.newItem = newItem;
//						$scope.filterCriteria.usedItem = usedItem;
//						filterCriteriaService.selectedFilterCriteria = $scope.filterCriteria;
//						$scope.dtInstance.rerender();
//					//	$route.reload();
//						console.log($scope.filterCriteria);
//					}
//					
//					$scope.clearSearchCriteria = function() {
//						$scope.maxAmount = "";
//						$scope.minAmount = "";
//						$scope.newItem = false;
//						$scope.usedItem = false;
//						
//						for (var i = 0; i < $scope.electronicsList.length; i++) {
//							$scope.electronicsList[i].selected = false; 
//						}
//						$scope.dtInstance.dataTable.fnClearTable();
//					}
//
//					$scope.findSubCategoriesSelected = function() {
//						var subCategories = [];
//						for (var i = 0; i < $scope.electronicsList.length; i++) {
//							if ($scope.electronicsList[i].selected == true) {
//								subCategories
//										.push($scope.electronicsList[i].subCategoryName);
//							}
//						}
//						return subCategories;
//					}
//
//				});
