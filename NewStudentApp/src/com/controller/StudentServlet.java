package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.utility.DBUtility;


//@WebServlet("/InsertServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public StudentServlet()
	{
		super();
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao=new StudentDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("uname");
		String marks=request.getParameter("marks");
		
		int id1=Integer.parseInt(id);
		double marks1=Double.parseDouble(marks);
		
		Student student=new Student(id1,name,marks1);
		
		//database code

		try {
			
			int i=dao.addStudent(student);
			
			if(i>0)
			{
				out.println("<b>Record inserted successfully<b>");
			}
			else {
				out.println("<b>Record not inserted.<b>");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
