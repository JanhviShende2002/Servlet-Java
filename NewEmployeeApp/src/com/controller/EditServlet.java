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

//@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO dao;
	@Override
	public void init() throws ServletException
	{
	 dao=new EmployeeDAO();
	}
    


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id1"));
		Employee employee=null;
		
		try {

			employee=dao.getEmployeeById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<h2>Student Update Form<h2><br>");
		
		out.print("<form action='UpdateServlet' method='get'>");
		
		out.print("<input type='text' name='id' value='"+employee.getId()+"'readonly>");
		out.print("<br>");
		
		out.print("<input type='text' name='uname' value='"+employee.getName()+"'>");
		out.print("<br>");
		
		out.print("<input type='text' name='usalary' value='"+employee.getSalary()+"'>");
		out.print("<br>");
		
		out.print("<input type='text' name='ucity' value='"+employee.getCity()+"'>");
		out.print("<br>");
		
		out.print("<input type='submit' value='UPDATE'>");
		out.print("</form>");
		
	}

}
