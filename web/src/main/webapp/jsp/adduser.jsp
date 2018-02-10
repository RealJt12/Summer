<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/favicon.ico" />
<title>Add User</title>
</head>
<body>
	<form action="/summer/adduserservlet" method="get">
		UserName: <input type="text" name="username"></input><br>
		Password: <input type="password" name="password"></input><br>
		Sex: <input type="text" name="sex"></input><br> Age: <input
			type="text" name="age"></input><br> Phone: <input type="text"
			name="phone"></input><br> Email: <input type="text" name="email"></input><br>
		Address: <input type="text" name="address"></input><br> <input
			type="submit" value="Add"></input>
	</form>

</body>
</html>