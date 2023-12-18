package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;


//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * private StudentDAO dao;
	 * 
	 * @Override public void init() throws ServletException{ dao=new StudentDAO(); }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String name = request.getParameter("uname");
		String marks = request.getParameter("marks");

		int id1 = Integer.parseInt(id);
		double marks1 = Double.parseDouble(marks);

		Student student = new Student(id1, name, marks1);
		// Database code

		try {

			int i = StudentDAO.updateStudent(student);

			if (i>0) {
				out.println("<b>Record Update Successfully.<b>");
				RequestDispatcher rd=request.getRequestDispatcher("/StudentReadServlet");
				rd.include(request, response);
			} else {
				out.println("record not updated");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
