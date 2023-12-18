package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO dao=new EmployeeDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 String id=request.getParameter("id");
		 String name=request.getParameter("name");
		 String salary=request.getParameter("salary");
		 String city=request.getParameter("city");
		 
		 int id1=Integer.parseInt(id);
		 double salary1=Double.parseDouble(salary);
		 
		 Employee employee=new Employee(id1, name, salary1, city);
		 
		 //database code
		 try {
			 int i=dao.addEmployee(employee);
			 
			 if(i>0)
			 {
				 out.print("<b>Record inserted Successfully.<b>");
			 }
			 else {
				 out.print("<b>Record Not inserted .<b>");

			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
