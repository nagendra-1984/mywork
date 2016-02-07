<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script>
// Declaring Application by using angular.module 

var app= angular.module("MyApp",[]);

// Controlling the Application using application Controller

app.controller('myCtrl',function($scope){
	$scope.first_name="Nagendra";
	$scope.last_name="Reddy";	
	$scope.myCol="red";
});

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Definding the Application and controller to controll the Anjular JS Application -->
<div ng-app="MyApp" ng-controller="myCtrl" ng-init="first_name='Nagendra';last_name='Kommireddy';quantity='10';cost='45'">

<p>Input something in the input box:</p>
<p>first Name: <input type="text" ng-model="first_name"></p>
<p>last Name: <input type="text" ng-model="last_name"></p>
<p>Quantiy: <input type="text" ng-model="quantity" ></p>
<p>Cost: <input type="text" ng-bind="cost" ng-model="cost" ></p>


<br>
<!--  Using Angular Js expression to concat the first Name and Last Name  -->
Full Name : {{ first_name +" "+ last_name}}
<br>
<input style="background-color:{{myCol}}" ng-model="myCol" value="{{myCol}}"/>
Color : {{ myCol }}
<p>Total in dollar: {{ quantity * cost }}</p>

<br>
</div>

</body>


</html>