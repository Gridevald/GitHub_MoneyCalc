<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<li class="bar_li"><a class="bar_li a active" href="${pageContext.request.contextPath}/main">Calculator</a></li>
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/help">Help</a></li>
		<li class="bar_li"><a class="bar_li a" href="${pageContext.request.contextPath}/contacts">Contacts</a></li>
		<li class="bar_li" style="float:right"><a class="bar_li a" href="${pageContext.request.contextPath}/log">${log}</a></li>
	</ul>

	<br><br>

	<c:choose>
		<c:when test="${fn:length(order_list) gt 0}">
			<c:set var="sum" scope="page" value="${0}"/>
			<table class="record_table" align="center">
				<tr>
					<th class="record_table_cell">No</th>
					<th class="record_table_cell">Value</th>
					<th class="record_table_cell">Description</th>
					<th class="record_table_cell">Date</th>
				</tr>
				<c:forEach var="list" items="${sessionScope.order_list}" varStatus="status">
					<tr>
						<td class="record_table_cell">${status.count}</td>
						<td class="record_table_cell">${list.value}</td>
						<c:set var="sum" scope="page" value="${sum + list.value}"/>
						<td class="record_table_cell">${list.description}</td>
						<td class="record_table_cell"><fmt:formatDate value="${list.date.time}" pattern="yyyy-MM-dd"/></td>
						<td style="padding: 5px;">
							<form action="${pageContext.request.contextPath}/deleteRecord" method="post">
								<input type="hidden" name="delete_id" value="${list.id}">
								<input type="submit" value="X">
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="record_table_cell">Sum:</td>
					<td class="record_table_cell">${sum}</td>
				</tr>
			</table>
		</c:when>

		<c:otherwise>
			<H3><p align="center">Oops! You don't have records yet...</p></H3>
		</c:otherwise>
	</c:choose>

	<br><br>

	<H3><p align="center">Add new record:</p></H3>

	<form action="${pageContext.request.contextPath}/main" method="post">
		<table align="center">
			<tr>
				<th>Sign</th>
				<th>Value</th>
				<th>Description</th>
				<th>Date</th>
			</tr>

			<tr>
				<td>
					<select name="r_sign">
						<option value="+">+</option>
						<option <c:if test="${requestScope.p_selected > 0}">selected</c:if> value="-">-</option>
					</select>
				</td>

				<td>
					<input type="text" name="r_value" placeholder="100.99" value="${requestScope.p_value}" size="10">
				</td>

				<td>
					<input type="text" name="r_description" placeholder="Salary! ^_^" value="${requestScope.p_description}" size="60">
				</td>

				<td>
					<input type="date" name="r_date" value="${requestScope.p_date}">
				</td>

				<td>
					<input type="submit" value="Add">
				</td>
			</tr>
		</table>
	</form>

	<table align="center">
		<tr>
			<td><span class="fault">${requestScope.r_fault}</span></td>
		</tr>
	</table>

</body>
</html>
