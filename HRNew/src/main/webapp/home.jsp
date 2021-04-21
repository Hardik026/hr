<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body style="background-color:#ccebff;">

	<h3 align="right" style="vertical-align: top;">Welcome ${username}</h3>
	<form method="post" action="logout" align="right" style="vertical-align: top;">
			<input type="submit" value="LOGOUT">
	</form>
	<br>
	<div align="center">
	<p>
	    Upload in CSV format to upload employee details
	</p>
		<form method="post" action="employees" enctype="multipart/form-data">
			<input type="file" name="file" required="required" /> 
			<input type="submit" value="UPLOAD">
		</form>
	</div>
	<br>
	</br>

	
	<table border="1" align="center" style="background-color:#99ff99;">
		<tr>
			<th>id</th>
			<th>Employee Code</th>
			<th>Employee Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Date Of Birth</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.employeeCode}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.location}</td>
				<td>${employee.email}</td>
				<td>${employee.dateOfBirth}</td>
				<td>
					<form method="post" action="employees/edit">
						<input type="hidden" value="${employee.id}" name="id"/>
						<input type="hidden" value="${employee.employeeCode}" name="employeeCode"/>
						<input type="hidden" value="${employee.employeeName}" name="employeeName"/>
						<input type="hidden" value="${employee.location}" name="location"/>
						<input type="hidden" value="${employee.email}" name="email"/>
						<input type="hidden" value="${employee.dateOfBirth}" name="dateOfBirth"/>
						<input type="submit" value="EDIT">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	</br>
	</br>
	</br>
	<div align="center">
	<p>Click to Download all employee details in CSV format</p>
    		<form method="post" action="employees/download" enctype="multipart/form-data">
    			<input type="submit" value="DOWNLOAD">
    		</form>
    	</div>
</body>
</html>