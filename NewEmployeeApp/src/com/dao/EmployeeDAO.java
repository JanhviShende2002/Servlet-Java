package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.utility.DBUtility;

public class EmployeeDAO {
//insert data
	public int addEmployee(Employee employee) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="insert into employees values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getName());
		ps.setDouble(3, employee.getSalary());
		ps.setString(4, employee.getCity());
		
		return ps.executeUpdate();
	}

	//delete data
	public int deleteEmployeeByID(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="delete from employees where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id1);
		
		return ps.executeUpdate();
	}

	
//update data
	public int updateEmployeeById(Employee employee) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="update employees set name=?,salary=?,city=? where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, employee.getName());
		ps.setDouble(2, employee.getSalary());
		ps.setString(3, employee.getCity());
		ps.setInt(4, employee.getId());
		return ps.executeUpdate();
	}

	
//read data
	public List<Employee> getAllEmployee() throws SQLException{
		
				List<Employee> list=new ArrayList<Employee>();
			
			Connection con=DBUtility.getDBConnection();
			String sql="Select * from employees";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Employee employee=new Employee();
				
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setCity(rs.getString(4));
				
				list.add(employee);
			}
			return list;
			
	}
//get Employee by id


	public Employee getEmployeeById(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="select * from employees where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id1);
		
		Employee employee=new Employee();
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setSalary(rs.getDouble(3));
			employee.setCity(rs.getString(4));
			
		}
			return employee;
	}

}
