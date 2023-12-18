package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;

//@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDAO dao;
       @Override
       public void init() throws ServletException{
    	   dao=new StudentDAO();
       }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
				int id=Integer.parseInt(request.getParameter("id"));

		Student student=null;
		try {
			student=dao.getStudentById(id);
		}catch (Exception e) {
		
		e.printStackTrace();
		}
		
		out.print("<h2> STUDENT UPDATE FORM </h2> <br>");
		out.print("<form action='UpdateServlet' method='get'>");
		
		out.print("<input type='text' name='id' value='"+student.getId()+"'readonly >");
		out.print("<br>");
		
		out.print("<input type='text' name='uname' value='"+student.getName()+"'>");
		out.print("<br>");
		
		out.print("<input type='text' name='marks' value='"+student.getMarks()+"'>");
		out.print("<br>");
		
		out.print("<input type='submit' value='UPDATE'>");
		out.print("</form>");
	
	}

}
