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

//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDAO dao = new PersonDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("eid");
		String name = request.getParameter("uname");
		String aNo = request.getParameter("aNo");
		String address = request.getParameter("uaddress");
		
		int id1=Integer.parseInt(id);
		int aadharNo=Integer.parseInt(aNo);
		
		Person person=new Person(id1, name, aadharNo, address);
		
		try {
			int i=dao.updatePerson(person);
			if(i>0)
			{
				out.print("Record Updated Succesfully.");
			}
			else {
				out.print("Record not deleted.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
