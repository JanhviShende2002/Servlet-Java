package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	public static Connection getDBConnection()
	{
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/techrelstudents","root","root");
			
		}catch(Exception e)
		{
			System.out.println("Exception Occured" + e);
		}
		return con;
		
	}

}


