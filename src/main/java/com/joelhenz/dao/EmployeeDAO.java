package com.joelhenz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.joelhenz.models.Employee;

public class EmployeeDAO {
	
	static {
		//1. register the driver class
		//Class.forName("com.mysql.jdbc.Driver"); //old driver, use new one (see following line)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //java.lang.Class<T>
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			
			/*
			 * to work mysql connection with tomcat: paste the mysql connector jar into the lib folder of tomcat
			 * -> C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib
			 * 
			 * */
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=Europe/Rome", "root", "dunpeal87$$"); //serverTimezone is needed
			
			//3. create statemenet object
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from employees;");
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				empList.add(emp);
			}
			
			//4. close connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}
	
	public EmployeeDAOResponse saveNewEmployee(Employee emp) {
		EmployeeDAOResponse daoResp = new EmployeeDAOResponse();
		try {
			
			/*
			 * to work mysql connection with tomcat: paste the mysql connector jar into the lib folder of tomcat
			 * -> C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib
			 * 
			 * */
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=Europe/Rome", "root", "dunpeal87$$"); //serverTimezone is needed
			
			//3. create statemenet object
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO employees VALUES ("+emp.getId()+",'"+emp.getName()+"',"+emp.getSalary()+")");
			
			//4. close connection
			connection.close();
			daoResp.setSuccess(true);
			daoResp.setRepsonseMsg("successfully inserted new employee");
			return daoResp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StringBuilder sb = new StringBuilder(); //use StringBuilder in single threaded applications because its faster than StringBuffer
			sb.append("something went wrong with inserting new employee, see following stacktrace: "+e.toString());
			
			daoResp.setSuccess(false);
			daoResp.setRepsonseMsg(sb.toString());
			return daoResp;
		}
	}
}
