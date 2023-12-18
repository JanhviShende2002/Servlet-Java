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

import com.dao.PersonDAO;
import com.model.Person;


//@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDAO dao=new PersonDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			List<Person> list=dao.getAllPersons();
			Iterator<Person> itr=list.iterator();
			
			out.print("<table>");
			out.print("<tr>");
			
			out.print("<th> ID </th>");
			out.print("<th> Name </th>");
			out.print("<th> Aadhar No </th>");
			out.print("<th> Address </th>");

			out.print("</tr>");
			
			while(itr.hasNext()) {
				Person person=itr.next();
			
				out.print("<tr>");
				out.print("<td>" + person.getId() +"</td>");
				out.print("<td>" + person.getName() +"</td>");
				out.print("<td>" + person.getAadharNo() +"</td>");
				out.print("<td>" + person.getAddress() +"</td>");

				out.print("</tr>");
			}
			out.print("</table>");
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
}
