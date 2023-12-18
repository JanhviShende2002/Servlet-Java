package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.utility.DBUtility;


//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlet() {
        super();
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao=new StudentDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("did");
		
		int id1=Integer.parseInt(id);
		//databse
		try {
			int i=dao.deleteStudentById(id1);
			
			if(i>0)
			{
				System.out.println("<b> Record deleted Succesfully .<b>");
			}
			else {
				System.out.println("<b> Record not deleted .<b>");
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
