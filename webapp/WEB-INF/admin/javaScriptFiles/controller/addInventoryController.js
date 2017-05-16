angular.module("mainApp")
.controller("addInventoryController",function($scope,addInventoryService,fileReader){

	$scope.productType=["Phone","Laptop","Tv","Shoes","--Please Select--"];
	
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
		item.image = $scope.imageSrc;
		addInventoryService.addInventory(item);	
	}
});