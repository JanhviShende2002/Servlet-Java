package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.model.Book;


//@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao=new BookDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			List<Book> list=dao.displayAllBooks();
			
			Iterator<Book> itr=list.iterator();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> ID </th>");
			out.print("<th> Name </th>");
			out.print("<th> Price </th>");
			out.print("<th> Author </th>");

			out.print("</tr>");
			
			while (itr.hasNext()) {
				Book book =  itr.next();
				out.print("<tr>");
				out.print("<td>" + book.getId() +"</td>");
				out.print("<td>" + book.getName() +"</td>");
				out.print("<td>" + book.getPrice() +"</td>");
				out.print("<td>" + book.getAuthor() +"</td>");

				out.print("</tr>");
				
			}
			
			out.print("</table>");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
