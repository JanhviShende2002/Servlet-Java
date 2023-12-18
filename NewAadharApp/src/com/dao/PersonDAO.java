package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Person;
import com.utility.DBUtility;

public class PersonDAO {
	//insert person
	public int addPerson(Person person) throws SQLException {
		
	Connection con=DBUtility.getDBConnection();
	String sql="insert into persons values(?,?,?,?)";
	
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setInt(1, person.getId());
	ps.setString(2, person.getName());
	ps.setInt(3, person.getAadharNo());
	ps.setString(4, person.getAddress());
	return ps.executeUpdate();
	
	}

//delete Person
	public int deletePerson(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="delete from persons where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id1);
		return ps.executeUpdate();
	}
	//upadte person
	public int updatePerson(Person person) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="update persons set name=?,aadharNo=?,address=? where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, person.getName());
		ps.setInt(2, person.getAadharNo());
		ps.setString(3, person.getAddress());
		ps.setInt(4, person.getId());
		
		return ps.executeUpdate();
		
	}
	//disply Persons
	
	public  List<Person> getAllPersons()throws SQLException
	{
		List<Person> list=new ArrayList<>();
		Connection con=DBUtility.getDBConnection();
		String sql="select * from persons";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Person person=new Person();
		
			person.setId(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setAadharNo(rs.getInt(3));
			person.setAddress(rs.getString(4));
			
			list.add(person);	
		}
		
		return list;
		
	}

}
