package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;

//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EmployeeDAO  dao=new EmployeeDAO();
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();	
	
String id=request.getParameter("id");

	int id1=Integer.parseInt(id);
	
	try {
		int i=dao.deleteEmployeeByID(id1);
		
		if(i>0)
		{
			out.print("<b>Record deleted succesfully.<b>");
		}
		else {
			out.print("<b>Record not deleted .<b>");

		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}
