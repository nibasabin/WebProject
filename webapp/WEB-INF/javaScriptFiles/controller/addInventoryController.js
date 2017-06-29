angular.module("mainApp")
.controller("addInventoryController",function($scope,$compile,DTOptionsBuilder, DTColumnBuilder,$q,addInventoryService,fileReader,itemTypeService,$base64){

	$scope.dtInstance = {};
	var init = function (){
		$scope.item={};
		$scope.item.category="Others";
		$scope.item.type="Computer Accessories";
		$scope.item.price=0;
		$scope.item.description = ""

		$scope.itemTypeSelected = false;
		$scope.itemCategory = itemTypeService.categoryList;
	}
	init();
	
	$scope.showItemType = function(){
	if($scope.itemTypeSelected == true){
		return true;
	}
	return false;
	}

	$scope.itemType = function (){
		if($scope.item.category == 'Electronics'){
			$scope.itemTypeSelected = true;
			return itemTypeService.electronicsList;
		}
		if($scope.item.category == 'Clothes'){
			$scope.itemTypeSelected = true;
			return itemTypeService.clothingList;
		}
		if($scope.item.category == 'Shoes'){
			$scope.itemTypeSelected = true;
			return itemTypeService.shoesList;
		}
		if($scope.item.category == 'Bag'){
			$scope.itemTypeSelected = true;
			return itemTypeService.bagList;
		}
		if($scope.item.category == 'Perfumes'){
			$scope.itemTypeSelected = true;
			return itemTypeService.perfumesList;
		}
		if($scope.item.category == 'Furniture'){
			$scope.itemTypeSelected = true;
			return itemTypeService.furnitureList;
		}
		if($scope.item.category == 'Others'){
			$scope.itemTypeSelected = true;
			return itemTypeService.otherList;
		}
	}
	
	$scope.getFile = function () {
        $scope.progress = 0;
        fileReader.readAsDataUrl($scope.file, $scope)
                      .then(function(result) {
                          $scope.imageSrc = result;
                      });
    };
 
    $scope.$on("fileProgress", function(e, progress) {
        $scope.progress = progress.loaded / progress.total;
    });
 

	$scope.addInventory = function(item){
		if( $scope.imageSrc != null){
		item.image = $base64.encode($scope.imageSrc);
		}else {
			item.image = $base64.encode(addInventoryService.noImageEncoded());
		}
		
		if(item.condition == 'new'){
			item.usedItem = false;
			item.newItem = true;
		}else{
			item.usedItem = true;
			item.newItem = false;
		}
		addInventoryService.addInventory(item).then(function(response){
			if(response.status == 200){
				$scope.dtInstance.rerender();
				alert("item saved successfully");
				init();
			}
		});
		
	}
	
	$scope.dtOptions =DTOptionsBuilder.fromFnPromise(
			function() {
				var defer = $q.defer();
				addInventoryService.getUsersInventory().then(function(result) {
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
					DTColumnBuilder.newColumn(null).withTitle('Image').notSortable().withClass("dataTableImageColumn").renderWith(function(data,type,full){
						
						if (data.image == null){
							return '<img class ="dataTableImage" alt = "NO Image"/>';
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
										'</table>'+
										'<div class ="descriptionBox">'+data.description+'</div></td></div>'
											
									return dom;
									
							}),
					DTColumnBuilder.newColumn('price').withTitle('Price').withClass("dataTablePriceColumn"),
					DTColumnBuilder.newColumn(null).notSortable().withTitle('Update').withClass("dataTableUpdateColumn").renderWith(function(data,type,full){
					var dom ="";
					if(data.itemSold==false){
						dom = '<div class="sellItemButtons">'+
						'<button class ="dataTableAddToCartButton" type="button" ng-click="sellItem('+data.id+')" >Sell </button>'+
						'<button class ="dataTableAddToCartButton"type = "button" ng-click="updateItem()">Update</button>'+
						'<button class ="dataTableAddToCartButton" type ="button" ng-click="deleteItem('+data.id+')">Delete</button>'+
						'</div>';
					}else{
						dom = '<div class="sellItemButtons">'+
						'<button class ="dataTableAddToCartButton"type = "button" ng-click="updateItem()">Update</button>'+
						'<button class ="dataTableAddToCartButton" type ="button" ng-click="deleteItem('+data.id+')">Delete</button>'+
						'</div>';
					}
						
						return dom;
					})];
	
	$scope.sellItem = function(data){
		console.log("this is data"+data);
		addInventoryService.addToGlobalInventory(data).then(function(response){
			if(response.status == 200){
				$scope.dtInstance.rerender();
				alert("Item Posted For Sale on Global Market");
			}
		});

	}
	$scope.updateItem = function(data){
		console.log("this is data"+data);
	}
	$scope.deleteItem = function(data){
		addInventoryService.deleteItem(data).then(function(response){
			if(response.status == 200){
				$scope.dtInstance.rerender();
				alert("Item Deleted from Global and your Inventory");
			}
		});
	}
});