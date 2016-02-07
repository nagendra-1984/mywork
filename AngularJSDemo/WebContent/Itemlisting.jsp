<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script>

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Definding the Application and controller to controll the Anjular JS Application -->
<div ng-app="" ng-init="names=[{name:'Nagendra',pwd:'welcome'},{name:'Nagarjuna',pwd:'password'}]">

	<p> looping Names from initialisation </p>
	<ul>
		<li ng-repeat="item in names">
			Name: {{item.name}} 
			Password : {{item.pwd}}
		</li>
	</ul>

<br>
</div>

    <div id="App2" ng-app="namesList" ng-controller="NamesController">
        <h1>List of Names</h1>
        <div ng-repeat="_name in names" >
            <p>{{_name.username}} : {{_name.pwd}}</p> 
        </div>
        <ul>
        	<li ng-repeat="_pwd in pwds">
        		Pwd : {{_pwd}}
        	</li>
        </ul>
    </div>
    
    

</body>

<script>

var namesModule = angular.module("namesList", [])

namesModule.controller("NamesController",
    function($scope) {
 
	// providing the name and pwds in Names Arrays 
	
	$scope.names = [
            {username: "Nitin",pwd:"welcome"},
            {username: "Mukesh",pwd:"password"}
        ];
        
        $scope.pwds = [
            {pwd:"welcome"},{pwd:"password"}
            
         ];
    }
);
angular.bootstrap(document.getElementById("App2"),['namesList']);

</script>
</html>