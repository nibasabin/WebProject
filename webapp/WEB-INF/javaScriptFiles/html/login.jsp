<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.loginBody{
	background:#868dcc;
	position: absolute;
    height: 200px;
    width: 400px;
    margin: -100px 0 0 -200px;
    top: 30%;
    left: 50%;
}
.container{
	background:#f2f2f2;
	height: 290px;
    width: 400px;
}

.errormsg{
    text-align: center;
    color: red;
    width: 100%;
    height: 25px;
    /* background-color: blue; */
    padding-top: 5px;
	
}
.heading{
    background-color: #8bc5b0;
    padding-top: 10px;
    font-size: 40px;
    font-style: :italic;
    color: white;
    padding-bottom: 10px;
    text-align: center;
}
.submit{
    height: 30px;
    width: 80%;
    margin-left: 10%;
    margin-top: 25px;
    color: white;
    font-size: 20px;
    background-color: #c58b8b;
}

table{
    padding-top: 30px;
    padding-left: 39px;
    width: 99%;
}
input {
	height: 25px;
	width: 82%;
}
td{
	
}

</style>
</head>
<body class ="loginBody" >


	<div class="container">
		<div class="heading">
			<label >Login</label>
		</div>
		
		<form name='logInForm' action="loginCheck" method="post">
			<div class="errormsg">
				<label>${error}</label>
			</div>
			<table >
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
					<input class="submit" name="submit" type="submit" value="submit" />
		</form>
	</div>

</body>
</html>
