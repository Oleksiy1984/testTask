
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Laptop</title>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);

        function MyController($scope, $http) {

            $scope.getDataFromServer = function() {
                $http({
                    method : 'GET',
                    url : '/all'
                }).success(function(data, status, headers, config) {
                    $scope.config = data;

                }).error(function(data, status, headers, config) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                });

            };
        };
    </script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Laptops</h1>
    </div>
    <div data-ng-app="myApp">
        <div data-ng-controller="MyController">
            <button type="button" class="btn btn-success btn-lg"
                    data-ng-click="getDataFromServer()">All laptops</button>


            <p>
                <button type="button" class="btn btn-info" data-toggle="collapse"
                        data-target="#demo">User List</button>
            <div id="demo" class="collapse">
                <table id="searchTextResults" class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>RAM</th>
                    </tr>
                    <tr data-ng-repeat="(key,value) in config.users">
                        <td>{{laptop.id}}</td>
                        <td>{{ laptop.ram }}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script
        src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</body>
</html>
