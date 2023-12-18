package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.utility.DBUtility;

public class BookDAO {
	//insert book
	public int addBook(Book book) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="insert into books values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,book.getId());
		ps.setString(2, book.getName());
		ps.setDouble(3, book.getPrice());
		ps.setString(4, book.getAuthor());
		
		return ps.executeUpdate();
		
	}
	//Delete book
	public int deleteBookById(int id1) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="delete from books where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id1);
		
		return ps.executeUpdate();
	}
	//upadte book
	
	public int updatebook(Book book) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="update books set name=?,price=?,author=? where id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, book.getName());
		ps.setDouble(2, book.getPrice());
		ps.setString(3, book.getAuthor());
		ps.setInt(4, book.getId());
		
		return ps.executeUpdate();	
	}
	//display books
	public List<Book> displayAllBooks() throws SQLException
	{
		List<Book> list=new ArrayList<>();
		
		Connection con=DBUtility.getDBConnection();
		String sql="select * from books";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Book book=new Book();
			
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setPrice(rs.getDouble(3));
			book.setAuthor(rs.getString(4));
			
			list.add(book);
		}
		return list;
	}	
}
