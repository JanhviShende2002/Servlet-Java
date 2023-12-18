package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDAO;
import com.model.Person;

//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonDAO dao=new PersonDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String aNo=request.getParameter("aNo");
		String address =request.getParameter("address");
		
		int id1=Integer.parseInt(id);
		int aadharNo=Integer.parseInt(aNo);
		
		Person person=new Person(id1, name, aadharNo, address);
		try {
			int i=dao.addPerson(person);
			
			if(i>0)
			{
				out.print("Record inserted Successfully.");
			}
			else {
				out.print("Record not inserted.");
			}
		} catch (Exception e) {
		System.out.println(e);
		}
	}

}
