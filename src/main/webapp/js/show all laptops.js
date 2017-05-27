var app = angular.module('myApp', []);
function MyController($scope, $http) {

    $scope.getDataFromServer = function() {
        $http({
            method : 'GET',
            url : 'laptops'
        }).success(function(data, status, headers, config) {
            $scope.laptops = data;

        }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

    };
}
