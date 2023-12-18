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


//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EmployeeDAO dao=new EmployeeDAO();
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();	
	
	String id=request.getParameter("eid");
	String name=request.getParameter("uname");
	String salary=request.getParameter("usalary");
	String city=request.getParameter("ucity");
	
	int id1=Integer.parseInt(id);
	double salary1=Integer.parseInt(salary);
	
	Employee employee=new Employee(id1, name, salary1, city);
	
	try {
		int i=dao.updateEmployeeById(employee);
		if(i>0)
		{
			out.print("<b>Record updated successfully.<b>");
		}
		else {
			out.print("<b>Record not updated.<b>");

		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

}
