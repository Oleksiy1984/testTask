
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html data-ng-app="myApp">
<head>
    <title>Laptop</title>
    <link
            href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
            rel="stylesheet">
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/show all laptops.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Laptops</h1>
    </div>
    <div >
        <div data-ng-controller="MyController">
            <p>
                <button type="button" class="btn btn-info"
                        data-ng-click="getDataFromServer()"
                        data-toggle="collapse"
                        data-target="#demo">All laptops</button>
            <div id="demo" class="collapse">
                <table id="allResults" class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>RAM</th>
                        <th>CPU</th>
                        <th>Screen</th>
                        <th>Price</th>
                    </tr>
                    <tr data-ng-repeat="laptop in laptops">
                        <td>{{laptop.id}}</td>
                        <td>{{laptop.ram}}</td>
                        <td>{{laptop.cpu}}</td>
                        <td>{{laptop.screen}}</td>
                        <td>{{laptop.price}}</td>
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
