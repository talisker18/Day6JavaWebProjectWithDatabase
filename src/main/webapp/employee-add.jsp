<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
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
	
		<h2>add new employee</h2>
	
		<div class="container">
		
			
			
			<form action="TestServlet" method="post">
			
				<input type="hidden" id="employeeActionId" name="employeeAction" />
				
				<!-- with  class="form-control" in input element, the text field is set over the whole screen-->
				
				<!--<div class="form-group">
				
					<label for="employeeId">Employee id</label> <input type="text" name="employeeId" class="form-control"/>
				
				</div> -->
				
				<div class="form-group">
				
					<label for="employeeId">Employee id</label> <input type="text" name="employeeId"/>
				
				</div>
				<br/>
				
				<div class="form-group">
				
					<label for="employeeName">Employee name</label> <input type="text" name="employeeName"/>
				
				</div>
				<br/>
				<div class="form-group">
				
					<label for="employeeSalary">Employee salary</label> <input type="text" name="employeeSalary"/>
				
				</div>
				<br/>
				
				<input class="btn btn-success" type="submit" value="save new employee" onclick="executeEmployeeAction('insertNewEmployee');"/>
			
			</form>
			
			<br>
			<br>
			<a class="btn btn-primary" href="<%= request.getContextPath()%>/index.jsp">back to index page</a>
			
		</div>
		
		<!-- JavaScript Bundle with Popper (bootstrap)-->
	    <script
	        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	        crossorigin="anonymous">
	    </script>
	</body>
</html>