package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;
import java.util.List;


//@WebServlet("/ReadServlet")
public class ReadServlet<List> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
//    public ReadServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO dao=new EmployeeDAO();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//database code
		try {
			java.util.List<Employee> list=dao.getAllEmployee();
			Iterator<Employee> itr=list.iterator();
			
			out.print("<table>");
			out.print("<tr>");
			
			out.print("<th> ID </th>");
			out.print("<th> Name </th>");
			out.print("<th> Salary </th>");
			out.print("<th> City </th>");
			out.print("</tr>");
			
			while(itr.hasNext())
			{
				Employee emp=itr.next();
				
				out.print("<tr>");
				out.print("<td>" + emp.getId() + "</td>");
				out.print("<td>" + emp.getName() + "</td>");
				out.print("<td>" + emp.getSalary() + "</td>");
				out.print("<td>" + emp.getCity() + "</td>");
				
				out.print("<td>");
				out.print("<a href='DeleteServlet?id=" + emp.getId() + "'>" + "DELETE" + "</a>");
				out.print("</td>");
				
				out.print("<td>");
				out.print("<a href='EditServlet?id="+emp.getId()+"'>" + "UPDATE" + "</a>");
				out.print("</td>");

				out.print("</tr>");
			}
				out.print("</table>");
			
		} catch (Exception e) {
			out.print(e);
		}
	}

}
