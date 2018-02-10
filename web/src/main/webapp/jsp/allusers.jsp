<%@page import="com.realjt.summer.config.Config"%>
<%@page import="org.springframework.util.CollectionUtils"%>
<%@ page import="com.realjt.summer.summer.domain.User"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/favicon.ico" />
<title>All Users</title>
</head>
<body>
	全部用户
	<a href="<%=request.getContextPath()%>/jsp/adduser.jsp">Add</a>
	<br>
	<table id="alluser" border="1" cellpadding="4" cellspacing="0">
		<tr align="center">
			<th>Id</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Sex</th>
			<th>Age</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Address</th>
			<th>Operate</th>
		</tr>
		<%
			List<User> allUsers = (List<User>) request.getAttribute("allUsers");
			if (!CollectionUtils.isEmpty(allUsers))
			{
				for (User user : allUsers)
				{
		%>
		<tr align="center">
			<td><%=user.getId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td>
				<%
					if (0 == user.getSex())
							{
								out.print("男");
							} else
							{
								out.print("女");
							}
				%>
			</td>
			<td><%=user.getAge()%></td>
			<td><%=user.getPhone()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getAddress()%></td>
			<td><a href="updateuserservlet?id=<%=user.getId()%>">update</a>
				<a href="deleteuserservlet?id=<%=user.getId()%>">delete</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	Database:
	<%=Config.getString("url")%>
</body>
</html>