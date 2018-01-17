<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/icon.ico" />
<title>Hello</title>
</head>
<body>
	<%
		out.print("realjt 2012");
		out.print("<br/>");
		out.print("realjt 2012");
	%>
	<br />
	<%
		out.print("juntian");
		out.print("<br/>");
		out.print(session.getId());
		out.print("<br/>");
		out.print(request.getHeader("USER-AGENT"));
	%>

</body>
</html>