package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbcprepared {
	public static void main(String[] args) throws Exception {
		//Addinsert();
		Addupdate();
	}

	private static void Addupdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		int id=13;
		String fname="sonu";
		String lname="Rathor";
		int sallery=30000;
		int did=3;
		int i = stmt.executeUpdate("UPDATE EMPLOYEE SET FNAME='VIPIN' WHERE ID=3 ");
System.out.println("update");
		
	}

	public static void Addinsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		int id=13;
		String fname="sunil";
		String lname="Rathor";
		int sallery=15000;
		int did=2;
		String sql="INSERT INTO EMPLOYEE VALUES("+id+",'"+fname+"','"+lname+"',"+sallery+",'"+did+"')";
		int s=stmt.executeUpdate(sql);
		System.out.println("inserted");

		
	}
}