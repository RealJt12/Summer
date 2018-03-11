<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.ico" />
<title>登录</title>
</head>
<body>
	<script language="javascript" type="text/javascript">
		function refreshCode(contextPath) {
			document.getElementById("validateCode").src = contextPath
					+ "/validateCode" + "?id="
					+ parseInt(Math.random() * 10, 10);
			document.getElementById("loginMessage").innerText = "";
		}
	</script>

	<form action="<%=request.getContextPath()%>/login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value=""></input></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value=""></input></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="validateCode" value=""></input></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><img id="validateCode" alt=""
					src="<%=request.getContextPath()%>/validateCode"
					onclick="refreshCode('<%=request.getContextPath()%>')"></img></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录"
					style="width: 180px; height: 30px; font-size: 20px" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><font id="loginMessage"
					color="red"> <%=session.getAttribute("loginMessage") == null ? ""
					: session.getAttribute("loginMessage").toString()%>
				</font></td>
			</tr>
			<%
				session.removeAttribute("loginMessage");
			%>
		</table>
	</form>
</body>
</html>