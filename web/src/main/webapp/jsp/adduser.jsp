<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.ico" />
<title>Add User</title>
</head>
<body>
	<form action="/summer/adduser" method="post">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"
					value="<%=null != request.getParameter("username") ? request.getParameter("username") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					value="<%=null != request.getParameter("password") ? request.getParameter("password") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td><input type="text" name="sex"
					value="<%=null != request.getParameter("sex") ? request.getParameter("sex") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"
					value="<%=null != request.getParameter("age") ? request.getParameter("age") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"
					value="<%=null != request.getParameter("phone") ? request.getParameter("phone") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value="<%=null != request.getParameter("email") ? request.getParameter("email") : ""%>"></input></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=null != request.getParameter("address") ? request.getParameter("address") : ""%>"></input></td>
			</tr>
			<tr>
				<td><input type="submit" value="新增"></input></td>
				<td><font color="red"><%=null != request.getAttribute("message") ? request.getAttribute("message") : ""%></font></td>
			</tr>
		</table>
	</form>
</body>
</html>