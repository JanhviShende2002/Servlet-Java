package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.model.Book;

//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("eid");
		String name=request.getParameter("uname");
		String price=request.getParameter("uprice");
		String author=request.getParameter("uauthor");
		
		int id1=Integer.parseInt(id);
		double price1=Double.parseDouble(price);
		
		Book book=new Book(id1,name,price1,author);
		
		try {
			int i=dao.updatebook(book);
			if(i>0)
			{
				out.print("<b>record Updated Succesfully.<b>");
			}
			else {
				out.print("<b>record not Updated .<b>");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
