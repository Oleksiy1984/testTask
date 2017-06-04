var myApp = angular.module('myApp', []);

myApp.controller('MyController', ['$scope', '$filter', '$http','$timeout', function ($scope, $filter, $http, $timeout) {

//Delete
    $scope.delete = function (id,index) {

        $http.delete('/server?id='+ id)
            .success(function (result) {
                $scope.laptops.splice(index, 1);
                $scope.result = result;
                $scope.AlertMessage=false;
                $timeout(function () { $scope.AlertMessage = true; }, 4000);
            })
            .error(function (data, status) {
                console.log(data);
                $scope.result = data;
            });
    };

    //Edit
    $scope.edit = function (id,ram,cpu,screen,price) {
        $http.post('/server', {
            id:id,
            ram: ram,
            cpu:cpu,
            screen:screen,
            price:price
        })
            .success(function (result) {
                console.log(result);
                $scope.result = result;
                $scope.AlertMessage=false;
                $timeout(function () { $scope.AlertMessage = true; }, 4000);
            })
            .error(function (data, status) {
                console.log(data);
                $scope.result = data;
            });
    };

    //Find by id
    $scope.find = function (id) {

        $http.get('/server?id='+ id)
            .success(function (result) {
                console.log(result);
                console.log(id);
                $scope.laptop = result;
            })
            .error(function (data, status) {
                console.log(data);
            });
    };
    //GetAll
    $scope.getDataFromServer = function () {
        $http.get('/laptops')
            .success(function (result) {
                $scope.laptops = result;
            })
            .error(function (data, status) {
                console.log(data);
            });
    };

    //Insert
    $scope.addLaptop = function () {
        $http.put('/server', {
            ram: $scope.ram,
            cpu:$scope.cpu,
            screen:$scope.screen,
            price:$scope.price
        })
            .success(function (result) {

                console.log(result);
                $scope.result = result;
                $scope.AlertMessage=false;
                $timeout(function () { $scope.AlertMessage = true; }, 4000);
                $scope.ram = '';
                $scope.cpu='';
                $scope.screen='';
                $scope.price='';

            })
            .error(function (data, status) {
                console.log(data);
            });
    };
}]);