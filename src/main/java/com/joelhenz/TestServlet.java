package com.joelhenz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joelhenz.dao.EmployeeDAO;
import com.joelhenz.dao.EmployeeDAOResponse;
import com.joelhenz.models.Employee;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO empDAO = new EmployeeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath(); //gets the path of the clicked a href button (see index.jsp)
		
		String btnName = request.getParameter("employeeAction");
		System.out.println(btnName);
		
		//with String action = request.getServletPath(); it did not work
		
		switch(btnName) {
		case "addNewEmployee":
			addNewEmployee(request, response);
			break;
		case "listAllEmployes":
			listEmployees(request, response);
			break;
		case "insertNewEmployee":
			insertNewEmployee(request, response);
			break;
		}
	}
	
	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list=this.empDAO.getAllEmployees(); //get employee list from database
		
		
		//show the result statically in index.jsp. there, we need to access "employees". for this we need a jsp library: jstl
		//we have to add the jst jar NOT as buildpath, but in /Day6JavaWebProjectWithDatabase/src/main/webapp/WEB-INF/lib
		//and then add this line on the top of jsp file:
		//-> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		/*after adding the taglib, we can use following syntax to iterate over the list
		 * 
		 * 
		 * <c:forEach var="emp" items="${employees}">
		
			<tr>
				<td><c:out value="${emp.id}"/></td>
				<td><c:out value="${emp.name}"/></td>
				<td><c:out value="${emp.salary}"/></td>
			</tr>
		
		</c:forEach>
		 * 
		 * 
		 * */
		
		
		/**
		 * additionally, add bootstrap for css and javascript!!!!!!! see index.jsp
		 * 
		 * this adds some better structure too jsp page, like centered and nice table
		 * 
		 * */
		request.setAttribute("employees", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("getting employee form");
		
		//here go to a new jsp file to get to form
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-add.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String name = request.getParameter("employeeName");
		float salary = Float.parseFloat(request.getParameter("employeeSalary"));
		System.out.println("id: "+id+", name: "+name+", salary: "+salary);
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		
		EmployeeDAOResponse empDaoResp= this.empDAO.saveNewEmployee(emp);
		
		if(empDaoResp.isSuccess()) {
			request.setAttribute("savedEmployee", emp);
			request.setAttribute("savedEmployeeMsg", empDaoResp.getRepsonseMsg());
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee-inserted.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("savedEmployeeMsg", empDaoResp.getRepsonseMsg());
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee-inserted-no-success.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
