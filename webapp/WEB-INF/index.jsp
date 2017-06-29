<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<!-- Style Sheet  -->
<link href="../javaScriptFiles/css/homePage.css" rel="stylesheet" type="text/css" >
<link href="../javaScriptFiles/css/addInventory.css" rel="stylesheet" type="text/css" >

<!-- Datatable -->
<script src="../javaScriptFiles/JQueryDataTable/jquery.js" type ="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<link href="../javaScriptFiles/JQueryDataTable/dataTableCss.css" rel="stylesheet" type="text/css" >
<script src="../javaScriptFiles/JQueryDataTable/dataTable.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/JQueryDataTable/angular-datatables.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/JQueryDataTable/dataTables.scroller.min.js"></script>
<script src="../javaScriptFiles/JQueryDataTable/angular-datatables.scroller.min.js"></script>
<script src="../javaScriptFiles/angularJs/angular-base64.min.js"></script>


<script src="../javaScriptFiles/module/mainApp.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/module/serviceModule.js" type ="text/javascript"></script>


<script src="../javaScriptFiles/directives/HomePageDirective.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/directives/FileModel.js" type ="text/javascript"></script>
<!-- Controller -->
<script src="../javaScriptFiles/controller/addInventoryController.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/controller/mainAppController.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/controller/homePageController.js" type ="text/javascript"></script>
<!-- Service -->
<script src="../javaScriptFiles/service/addInventoryService.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/service/FileReader.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/service/itemTypeService.js" type ="text/javascript"></script>
<script src="../javaScriptFiles/service/filterCriteriaService.js" type ="text/javascript"></script>

<title>HomePageIndex.jsp</title>
</head>

<body ng-app="mainApp"  ng-controller = "mainAppController">
	<div class = "container	">
		<div class ="userLabel">
		<label>Welcome, ${firstLastName}</label>
		</div>
		<div class ="menuBar">
				<ul>
				  <li><a href="#/"><button>Home</button></a></li>
				  <li><a href="#addInventory"><button>Sell Item</button></a> </li>
				  <li><a href="#red"><button>History</button></a></li>
				  <li><a href="#Email"><button>Email</button></a></li>
	
				</ul>
				<form id="logOff" action ="/WebService/logout" method="get">
				<button class="logOffButton" type="submit">logoff</button>
				</form>
		</div>
		<div class ="view">
		 <div ng-view></div>
 		</div>
	</div>
</body>
</html> --%>