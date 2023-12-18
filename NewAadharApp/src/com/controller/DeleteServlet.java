package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDAO;


//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDAO dao=new PersonDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("did");
		
		int id1=Integer.parseInt(id);
		try {
			int i=dao.deletePerson(id1);
			if(i>0)
			{
				out.print("Record Deleted Successfully.");
			}
			else {
				out.print("Record not Deleted .");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
