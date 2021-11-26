<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>start page</title>
	
	<!-- CSS only (bootstrap)-->
	<link
	    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	    rel="stylesheet"
	    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	    crossorigin="anonymous">
	    
	<script type="text/javascript">
            function executeEmployeeAction(action) {
            	document.getElementById("employeeActionId").value=action;
            }
    </script>
    
</head>
<body>

	<h2>Welcome, what do you want to do?</h2>
	<br>
	<br>

	<div class="container">
	
		<form action="TestServlet" method="post">
		
			<input type="hidden" id="employeeActionId" name="employeeAction" />
			<input class="btn btn-success" type="submit" value="list all saved employees" onclick="executeEmployeeAction('listAllEmployes');"/>
			<input class="btn btn-success" type="submit" value="add new employee" onclick="executeEmployeeAction('addNewEmployee');" />
		
		</form>
		<br>
		<br>
		
		<!-- with a href i didtn work, so I implemented 1 form with different submit buttons, see above -->
		<!--  <a class="btn btn-success" name="listEmployee" href="<%= request.getContextPath()%>/TestServlet">list all employees</a>
		<br>
		<br>
		
		<a class="btn btn-success" href="<%= request.getContextPath()%>/newEmployee">add new employee</a>
		<br>
		<br>-->
	
	</div>

<!-- JavaScript Bundle with Popper (bootstrap)-->
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous">
    </script>
</body>
</html>