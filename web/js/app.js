var myApp = angular.module('myApp', []);

myApp.controller('myCtrl', function ($scope, $http) {
    $scope.message = "";
    $scope.error_mesage = "";

    //get all product
    $scope.getAllproduct = function () {
        $http({
            mehtod: "GET",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/products'
        }).then(
                function (response) {
                    $scope.products = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    $scope.getAllproduct();


    //save product
    $scope.newProduct = {};
    $scope.saveProduct = function () {
        $http({
            method: "POST",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/products',
            data: angular.toJson($scope.newProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product Saved Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
    
    //Select product by click
    
    $scope.clickedProduct = {};
    $scope.selectProduct = function(product){
        $scope.message = "Product Updated Successfully";
        $scope.clickedProduct = product;
    };
    
    //Update Product
    $scope.updateProduct = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/products',
            data: angular.toJson($scope.clickedProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product Update Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
    
    //sale product
    $scope.saleProduct = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/products',
            data: angular.toJson($scope.clickedProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product sold Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
    
    //Delete Product
    $scope.deleteProduct = function () {
        $http({
            method: "DELETE",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/products/'+$scope.clickedProduct.pid,
            data: angular.toJson($scope.newProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product Deleted Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    //Clear message
    
    $scope.messageClose = function(){
        $scope.message = "";
    $scope.error_mesage = "";
    };
    
    
     

});