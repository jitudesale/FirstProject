package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/orderdb";
	public static final String USER_NAME="root";
	public static final String USER_PASSWORD="Patan@123";
	static Connection con=null;
	public static  Connection getConnect()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver loaded");
			DriverManager.getConnection(JDBC_URL,USER_NAME,USER_PASSWORD);
			System.out.println("connection establish");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

	

}
