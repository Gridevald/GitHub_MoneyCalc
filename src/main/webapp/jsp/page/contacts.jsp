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
		<li class="bar_li"><a class="bar_li a active" href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
		<li class="bar_li" style="float:right"><a class="bar_li a" href="${pageContext.request.contextPath}/log">${log}</a></li>
	</ul>

	<br><br>

	<H3><p align="center">Contacts</p></H3>

	<div class="text_div"><p align="center">Author: Pavel Yudzitski</p></div>
	<div class="text_div"><p align="center">E-mail: PavelYudzitski@gmail.com</p></div>
	<br>
	<div class="text_div"><p align="center">If you have some questions contact me.</p></div>

</body>
</html>
