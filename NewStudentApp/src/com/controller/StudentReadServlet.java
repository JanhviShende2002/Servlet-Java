package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.utility.DBUtility;

//@WebServlet("/StudentReadServlet")
public class StudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// database code

		try {
			
			List<Student> list = dao.getAllStudents();

			Iterator<Student> itr = list.iterator();

			out.print("<table>");
			out.print("<tr>");
			out.print("<th> ID </th>");
			out.print("<th> Name </th>");
			out.print("<th> Marks </th>");

			out.print("</tr>");

			while (itr.hasNext()) {
				Student stud = itr.next();
				out.print("<tr>");
				out.print("<td>" + stud.getId() + "</td>");
				out.print("<td>" + stud.getName() + "</td>");
				out.print("<td>" + stud.getMarks() + "</td>");

				out.print("<td>");
				out.print("<a href='DeleteServlet?did=" + stud.getId() + "'>" + "DELETE" + "</a>");

				out.print("</td>");

				out.print("<td>");
				out.print("<a href='EditServlet?id="+stud.getId()+"'>" + "UPDATE" + "</a> ");
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
