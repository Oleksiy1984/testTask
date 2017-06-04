var myApp = angular.module('myApp', []);

myApp.controller('MyController', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

//Delete
    $scope.delete = function (id,index) {

        $http.delete('/server?id='+ id)
            .success(function (result) {
                $scope.laptops.splice(index, 1);
                $scope.result = result;
            })
            .error(function (data, status) {
                console.log(data);
            });
    };

    //Edit
    $scope.visible = false;
    $scope.post = function (id,index) {

        $http.delete('/server?id='+ id)
            .success(function (result) {
                $scope.laptops.splice(index, 1);
                $scope.result = result;
            })
            .error(function (data, status) {
                console.log(data);
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