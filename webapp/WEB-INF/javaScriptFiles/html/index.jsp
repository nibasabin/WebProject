<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>UserPage</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
<link href="../javaScriptFiles/css/commonPage.css" rel="stylesheet" type="text/css" >
<link href="../javaScriptFiles/JQueryDataTable/dataTableCss.css" rel="stylesheet" type="text/css" >

<script src="../javaScriptFiles/JQueryDataTable/jquery.js" type ="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>

<script src="../javaScriptFiles/JQueryDataTable/dataTable.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/JQueryDataTable/angular-datatables.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/JQueryDataTable/dataTables.scroller.min.js"></script>
<script src="../javaScriptFiles/JQueryDataTable/angular-datatables.scroller.min.js"></script>
<script src="../javaScriptFiles/angularJs/angular-base64.min.js"></script>

<script src="../javaScriptFiles/module/mainApp.js" type ="text/javascript" ></script>
<script src="../javaScriptFiles/controller/addInventoryController.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/controller/commonPageController.js" type ="text/javascript"></script>

<script src="../javaScriptFiles/service/itemTypeService.js" type ="text/javascript" ></script>
<script src="../javaScriptFiles/service/addInventoryService.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/service/FileReader.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/service/filterCriteriaService.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/directives/FileModel.js" type ="text/javascript"></script>

</head>
<body ng-app ="mainApp">

<div id ="userPageContainer" class = "container" >

		<div class="row userPageOptionBar">
			<nav class="navbar navbar mainMenu">
		  	<div class="container-fluid " >		
			    <ul class="nav navbar-nav">
				  <li><a href="#/"><button class ="userPageButton">Home</button></a></li>
				  <li><a href="#addInventory"><button class ="userPageButton">Sell Item</button></a> </li>
				  <li><a href="#red"><button class ="userPageButton">History</button></a></li>
				  <li><a href="#Email"><button class ="userPageButton">Email</button></a></li>
	
				</ul>
				<form id="logOff" action ="/WebService/logout" method="get">
				<button class ="userPageButton logOffButton" type="submit">logoff</button>
				</form>
		  </div>
		</nav>
		</div>
		<div class ="row userName">
			<label>Welcome, ${firstLastName}</label>
		</div>

		 <div ng-view></div>

	
</div>
</body>
</html>
