<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" errorPage="/error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/icon.ico" />
<title>Hello</title>
</head>
<body>
	<%
		out.println("RealJt 一直被模仿，从未被超越");
	%>
	<br>
	<br>
	<%
		Date date = new Date();
		out.println("当前时间: " + date);
	%>
	<br>
	<br>
	<%
		out.print("host=" + request.getHeader("host"));
		out.print("<br>");
		out.print("session=" + session.getId());
		out.print("<br/>");
		out.print("user-agent=" + request.getHeader("user-agent"));
		out.print("<br/>");
		out.println("accept=" + request.getHeader("accept"));
		out.print("<br/>");
		out.println("cookie: " + request.getHeader("cookie"));
	%>
	<br>
	<br>

	<a href="summerservlet">Summer</a>

</body>
</html>