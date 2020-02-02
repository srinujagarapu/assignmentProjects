 var app = angular.module("StoreDetailsManagement", []);
         
            //Controller Part
            app.controller("StoreDetailsManagementController", function($scope, $http) {
         
                //Initialize page with default data which is blank in this example
                $scope.storeDetails = [];
                $scope.form = {
                    id : -1,
                    type : "",
                    name : "",
                    address : "",
                    address2 : "",
                    city : "",
                    state : "",
                    zip : "",
                    hours : "",
                    services : ""
                    
                };
         
                //Now load the data from server
                _refreshPageData();
         
                //HTTP POST/PUT methods for add/edit employee
                $scope.submitStore = function() {
         
                   
                	 var method = "";
                     var url = "";
                     if ($scope.form.id == -1) {
                         //Id is absent so add employee - POST operation
                         method = "POST";
                         url = 'employees';
                     } else {
                         //If Id is present, it's edit operation - PUT operation
                         method = "PUT";
                         url = 'http://localhost:8083/details/' + $scope.form.id;
                     }
                  
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json',
                            'Authorization' :'Basic c3JpbnU6dGVzdA=='
                        }
                    }).then( _success, _error );
                };
         
                
                $scope.removeStore = function(store) {
                    $http({
                        method : 'DELETE',
                        url : 'http://localhost:8083/details/' + store.id,
                        headers : {
                            
                            'Authorization' :'Basic c3JpbnU6dGVzdA=='
                        }
                    }).then(function successCallback(response) {
                    	console.log(response.data);
                    	 _refreshPageData();
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                };
 
               
                $scope.editStore = function(store) {
                    $scope.form.id = store.id;
                    $scope.form.type = store.type;
                    $scope.form.name = store.name;
                    $scope.form.address = store.address;
                    $scope.form.address2 = store.address2;
                    $scope.form.city = store.city;
                    $scope.form.state = store.state;
                    $scope.form.zip = store.zip;
                    $scope.form.hours = store.hours;
                    $scope.form.services = store.services;
                };
         
                /* Private Methods */
                //HTTP GET- get all employees collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8083/details',
                        headers : {
                               
                                 'Authorization' :'Basic c3JpbnU6dGVzdA=='
                             }
                    }).then(function successCallback(response) {
                    	console.log(response.data);
                        $scope.storeDetails = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                	 $scope.form.id = -1;
                     $scope.form.type = "";
                     $scope.form.name = "";
                     $scope.form.address = "";
                     $scope.form.address2 = "";
                     $scope.form.city = "";
                     $scope.form.state = "";
                     $scope.form.zip = "";
                     $scope.form.hours = "";
                     $scope.form.services = "";
                };
            });