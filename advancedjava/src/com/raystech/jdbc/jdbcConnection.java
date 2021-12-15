package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcConnection {
	public static void main(String[] args) throws Exception {
		// addselec();
		addupdate();
		Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet sd = stmt.executeQuery("select *from employee");
		while (sd.next()) {
			System.out.print(sd.getInt(1));
			System.out.print("\t" + sd.getString(2));
			System.out.print("\t" + sd.getString(3));
			System.out.print("\t" + sd.getInt(4));
			System.out.println("\t" + sd.getInt(5));

		}
		stmt.close();
		con.close();
	}

	// private static void addupdate() throws Exception {
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection con=
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	// Statement stmt=con.createStatement();
	// int sd=stmt.executeUpdate("INSERT into employee
	// values(9,'Akansha','rawal',6000,2)");

	// System.out.println(sd+"record as insert");
	// }

	private static void addupdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		int i = stmt.executeUpdate("UPDATE EMPLOYEE SET FNAME='VIPIN' WHERE ID=3 ");
		System.out.println("update" + i);
	

	}

	private static void addselec() throws Exception {
		}

}
