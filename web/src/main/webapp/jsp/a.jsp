<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="images/icon.ico" />
<title>a.jsp</title>
</head>
<body>
	A page
	<jsp:include page="b.jsp"><jsp:param name="name"
			value="RealJt" />
	</jsp:include>

	<jsp:forward page="b.jsp">
		<jsp:param name="name" value="RealJt" />
	</jsp:forward>

</body>
</html>