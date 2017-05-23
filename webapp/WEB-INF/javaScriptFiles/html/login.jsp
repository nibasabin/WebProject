<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<script type="text/javascript" src="javaScriptFiles/controller/signUpController.js"></script>
<script type="text/javascript" src="javaScriptFiles/service/signUpService.js"></script>

<link href="javaScriptFiles/css/logInSignUp.css" rel="stylesheet" type="text/css" >

</head>
<body class="loginBody" ng-app="sighUpModule">

	<center>
		<div class="container">
			<div class="containerLeft">
				<div class="login">
					<div class="heading">
						<label>Log In</label>
					</div>

					<form name='logInForm' action="loginCheck" method="post">
						<br>
						<div class="errormsg">
							<label>${error}</label>
						</div>
						<br>
						<table>
							<tr>
								<td>User:</td>
								<td><input type='text' name='j_username' value=''></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type='password' name='j_password' /></td>
							</tr>
							<tr>
							</tr>

						</table>
						<label>Forgot Password !</label> <input id="loginSubmit"
							class="submit" name="submit" type="submit" value="Log In" />
					</form>
				</div>


			</div>
			<div class="containerRight" ng-controller="signUpController">
				<div class="heading">
					<label>New User Sign Up</label>
				</div>	<br> 
				<div class="errormsg" >
				<label id="passwordErrorMsg"></label>
				</div>
			<form>
				<table>
					<tr>
						<td>First Name:</td>
						<td><input type='text' name='firstName' ng-model='user.firstName' required></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type='text' name='lastName' ng-model='user.lastName' required/></td>
					</tr>
					<tr>
						<td>Email Address:</td>
						<td><input type='text' name='emailId' ng-model='user.emailId' required /></td>
					</tr>

					<tr>
						<td>Password:</td>
						<td><input type="password" name='password' ng-model='user.password' required/></td>
					</tr>

					<tr>
						<td>Confirm Password:</td>
						<td><input type='password' name='confirmPassword' ng-model='user.confirmPassword' required/></td>
					</tr>
					<tr>
						<td>Date Of Birth:</td>
						<td><input type='date' name='dateOfBirth' ng-model='user.dateOfBirth'/></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type='text' name='address' ng-model='user.address' /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><input type='text' name='city' ng-model='user.city' /></td>
					</tr>
					<tr>
						<td>State:</td>
						<td><input type='text' name='state' ng-model='user.state' /></td>
					</tr>
					<tr>
						<td>Zip Code:</td>
						<td><input type='text' name='zipCode' ng-model='user.zipCode' /></td>
					</tr>

				</table>
				<input class="submit" type="submit" value="Submit" ng-click="createUser(user)" />
				</form>
					
			</div>

		</div>
	</center>
</body>
</html>
