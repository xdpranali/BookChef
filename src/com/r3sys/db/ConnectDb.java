package com.r3sys.db;

import java.sql.*;

public class ConnectDb 
{
	public static Connection con = null;
	
	public static Connection dbCon()
	{
		try
		{
			if(con == null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/offerDB", "root", "");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
