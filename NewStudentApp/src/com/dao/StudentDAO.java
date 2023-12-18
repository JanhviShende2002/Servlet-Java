package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.mysql.cj.protocol.Resultset;
import com.utility.DBUtility;

//DATABASE OPERATION 

public class StudentDAO {
	// inserted data
	public int addStudent(Student student) throws SQLException { //  1 xyz 55
		// to load driver class // to get connection

		Connection con = DBUtility.getDBConnection();
		String sql = "insert into students values(?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, student.getId());    //1
		ps.setString(2, student.getName()); //xyz
		ps.setDouble(3, student.getMarks()); //55

		return ps.executeUpdate();
	}

	// delete data
	public int deleteStudentById(int id1) throws SQLException {
		Connection con = DBUtility.getDBConnection();
		String sql = "delete from students where id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id1);

		return ps.executeUpdate();

	}
//update data
	public static int updateStudent(Student student) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="update students set name=? , marks=? where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, student.getName());
		ps.setDouble(2, student.getMarks());
		ps.setInt(3, student.getId());
		
		return ps.executeUpdate();
	}

	
	//display data
	public List<Student> getAllStudents() throws SQLException {
		List<Student> list=new ArrayList<Student>();
		
		Connection con=DBUtility.getDBConnection();
		String sql="Select * from students";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setMarks(rs.getDouble(3));
			
			list.add(student);
		}
		return list;
	}

//get student by id
	
	public Student getStudentById(int id) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="select * from students where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		Student student=new Student();
		Resultset rs=(Resultset) ps.executeQuery();
		while(((ResultSet) rs).next())
		{
			student.setId(((ResultSet) rs).getInt(1));
			student.setName(((ResultSet) rs).getString(2));
			student.setMarks(((ResultSet) rs).getDouble(3));
			
		}
		
		return student;
	}
	


}
