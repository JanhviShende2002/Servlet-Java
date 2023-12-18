package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;


//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("did");
		
		int id1=Integer.parseInt(id);
		
		try {
			int i=dao.deleteBookById(id1);
			
			if(i>0)
			{
				out.print("<b>Record Deleted Succesfully.<b>");
			}
			else {
				out.print("<b>Record  not Deleted.<b>");

			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
