<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>Money Calc</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/project.css">
</head>
<body>

	<ul class="bar_ul">
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/home">Home</a></li>
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/main">Calculator</a></li>
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/help">Help</a></li>
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
		<li class="bar_li" style="float:right"><a class="bar_li a" href="${pageContext.request.contextPath}/log">${log}</a></li>
	</ul>

	<br><br>

	<form action="${pageContext.request.contextPath}/register" method="post">
		<table align="center">
			<tr>
				<td>e-mail:</td>
				<td><input type="text" name="reg_email" placeholder="mail@site.com" value="${param.reg_email}"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="reg_password_1" placeholder="password"></td>
			</tr>
				<tr>
				<td>repeat password:</td>
				<td><input type="password" name="reg_password_2" placeholder="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>

	<table align="center">
		<tr>
			<td><span class="fault">${requestScope.sign_fault}</span></td>
		</tr>
	</table>

</body>
</html>
