<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/jquery-ui-1.9.0.custom.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/scripts/jquery-1.8.2.js" />"></script>
<script src="<c:url value="/resources/scripts/jquery-ui-1.9.0.custom.min.js" />"></script>

<title>Edit User</title>
</head>
<body>
	<script>
		$(function() {
			$("input[type=submit], a, button").button();
			
		    $( "#dateOfBirth" ).datepicker({
		        showOn: "button",
		        buttonImage: "<c:url value="/resources/css/images/calendar.gif" />",
		        buttonImageOnly: true
		    });
		});
	</script>
	<div class="mainContent">

		<h1>Edit User</h1>

		<form:form id="editUserForm" modelAttribute="user" method="post" action="update">
			<table>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input class="textfield" path="firstName"
							value="${userEdited.firstName}" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input class="textfield" path="lastName" value="${userEdited.lastName}" /></td>
				</tr>
				<tr>
					<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
					<td><form:input id="dateOfBirth" class="dobTextfield" path="dateOfBirth" value="${userEdited.dateOfBirth}" /></td>
				</tr>
				<tr>
					<td><form:label path="phoneNumber">Phone</form:label></td>
					<td><form:input class="textfield" path="phoneNumber"
							value="${userEdited.phoneNumber}" /></td>
				</tr>
				<tr>
					<td><form:label path="salary">Salary</form:label></td>
					<td><form:input class="textfield" path="salary" value="${userEdited.salary}" /></td>
				</tr>
				<tr>
					<td><form:label path="state">State</form:label></td>
					<td><form:input class="stateTextfield" path="state" value="${userEdited.state}" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input class="textfield"path="email" value="${userEdited.email}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="userId"
						value="${userEdited.userId}" /> <input type="submit"
						value="Update" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<a href="main">See User List</a>
	</div>
</body>
</html>