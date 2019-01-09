var myApp = angular.module('myApp', []);

myApp.controller('myCtrl', function ($scope, $http) {
    $scope.message = "";
    $scope.error_mesage = "";

    
     //get all DrugCompany
    $scope.getAllDrugCompany = function () {
        $http({
            mehtod: "GET",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/drugCompanys'
        }).then(
                function (response) {
                    $scope.drugCompanys = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    $scope.getAllDrugCompany();


    //save DrugCompany
    $scope.newDrugCompany = {};
    $scope.saveDrugCompany = function () {
        $http({
            method: "POST",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/drugCompanys',
            data: angular.toJson($scope.newDrugCompany),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "DrugCompany Saved Successfully";
                    $scope.getAllDrugCompany();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
    
    //Select DrugCompany by click
    
    $scope.clickedDrugCompany = {};
    $scope.selectDrugCompany = function(drug_company){
        $scope.message = "DrugCompany Updated Successfully";
        $scope.clickedDrugCompany = drug_company;
    };
    
    //Update Product
    $scope.updateDrugCompany = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/drugCompanys',
            data: angular.toJson($scope.clickedDrugCompany),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "DrugCompany Update Successfully";
                    $scope.getAllDrugCompany();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
    
    //Delete DrugCompany
    $scope.deleteDrugCompany = function () {
        $http({
            method: "DELETE",
            url: 'http://localhost:8080/Project_AngularJS_Rest/webresources/drugCompanys/'+$scope.clickedDrugCompany.dc_id,
            data: angular.toJson($scope.newDrugCompany),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "DrugCompany Deleted Successfully";
                    $scope.getAllDrugCompany();
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