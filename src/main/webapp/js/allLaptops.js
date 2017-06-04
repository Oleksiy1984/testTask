// var myApp = angular.module('myApp', []);
// function MyController($scope, $http) {
//
//     $scope.getDataFromServer = function() {
//         $http({
//             method : 'GET',
//             url : 'laptops'
//         }).success(function(data, status, headers, config) {
//             $scope.laptops = data;
//
//         }).error(function(data, status, headers, config) {
//             // called asynchronously if an error occurs
//             // or server returns response with an error status.
//         });
//
//     };
// }

var myApp = angular.module('myApp', []);

myApp.controller('MyController', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

       $http.get('/laptops')
        .success(function (result) {
            $scope.laptops = result;
        })
        .error(function (data, status) {
            console.log(data);
        });

    $scope.ram = '';
    $scope.addLaptop = function () {
        $http.put('/server', {
            ram: $scope.ram,
            cpu:$scope.cpu,
            screen:$scope.screen,
            price:$scope.price
        })
            .success(function (result) {

                console.log(result);
                $scope.laptops = result;
                $scope.ram = '';

            })
            .error(function (data, status) {
                console.log(data);
            });
    };
}]);