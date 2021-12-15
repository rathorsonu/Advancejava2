package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionHandling1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");

		con.setAutoCommit(false);
		Statement stmt = con.createStatement();

	 stmt.executeUpdate("insert into employee values(21,'sonu','sharma',20000,1)");
	 stmt.executeUpdate("insert into employee values(22,'sonu','rathor',20000,1)");
	 stmt.executeUpdate("insert into employee values(23,'sonu','sharma',15000,1)");
		System.out.println("bedd");

		con.commit();

		System.out.println("gdhdh");
		stmt.close();
		con.close();
	}
}
