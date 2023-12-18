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

//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String author=request.getParameter("author");
		
		int id1=Integer.parseInt(id);
		double price1=Double.parseDouble(price);
		
		Book book=new Book(id1,name,price1,author);
		
		try {
			int i =dao.addBook(book);
			if(i>0)
			{
				out.print("<b>Record inserted successfully.<b>");
			}
			else {
				out.print("<b>Record not inserted .<b>");

			}
			
		} catch (Exception e) {

		System.out.print(e);}

		
		
	}

}
