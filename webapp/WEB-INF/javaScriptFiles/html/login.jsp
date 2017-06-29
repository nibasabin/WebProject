<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="javaScriptFiles/JQueryDataTable/dataTableCss.css" rel="stylesheet" type="text/css" >
<link href="javaScriptFiles/css/commonPage.css" rel="stylesheet" type="text/css" >
<link href="javaScriptFiles/css/logInSignUp.css" rel="stylesheet" type="text/css" >

<script src="javaScriptFiles/JQueryDataTable/jquery.js" type ="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>

<script src="javaScriptFiles/JQueryDataTable/dataTable.js" type ="text/javascript"></script>
<script src="javaScriptFiles/JQueryDataTable/angular-datatables.js" type ="text/javascript"></script>
<script src="javaScriptFiles/JQueryDataTable/dataTables.scroller.min.js"></script>
<script src="javaScriptFiles/JQueryDataTable/angular-datatables.scroller.min.js"></script>
<script src="javaScriptFiles/angularJs/angular-base64.min.js"></script>



<script src="javaScriptFiles/module/mainApp.js" type="text/javascript" ></script>
<script src="javaScriptFiles/controller/signUpController.js" type="text/javascript"></script>
<script src="javaScriptFiles/controller/commonPageController.js" type="text/javascript"></script>
<script src="javaScriptFiles/service/signUpService.js" type="text/javascript"></script>
<script src="javaScriptFiles/service/itemTypeService.js" type="text/javascript" ></script>
<script src="javaScriptFiles/service/filterCriteriaService.js" type="text/javascript"></script>




</head>
<body class="loginBody" ng-app ="mainApp">

<% 
String userName = request.getParameter("j_username");
//session.setAttribute("username", userName); %>

<div id ="loginContainer" class = "container-fluid" >


	<div class="row logInMenuBar">
		<nav class="navbar navbar">
		  <div class="container-fluid login" >		
		      <form name='logInForm' action="loginCheck" method="post">
			    <ul class="nav navbar-nav">
					<li><label>User :</label></li>
					<li><input  type='text' name='j_username' value=''></li>
					<li><label >Password :</label></li>
					<li><input type='password' name='j_password' /></li>
					<li><input class ="signInButton" name="submit" type="submit" value="Sign In" /></li>
					<li><a href="#signUp"><button type="button" class = "signUpButton">Sign Up</button></a></li>
			    </ul>
			    </form>
		  </div>
		</nav>
	</div>
	<div class = "row">
			<label class="signInErrorMsg">${error}</label>
	</div>
	
	<div class = "row">
		<div class ="displayPannel" ng-view></div>
	</div>
	
</div>
</body>
</html>
