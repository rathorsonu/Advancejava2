package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		//stmt.addBatch("insert into employee(id,fname,lname,sallery,dept_id)values(29,'naveen','rathor',10000,2)");

		//stmt.addBatch("insert into employee(id,fname,lname,sallery,dept_id)values(30,'somya','gupta',15000,1)");

		//stmt.addBatch("insert into employee(id,fname,lname,sallery,dept_id)values(31,'harsh','rathor','11600',3)");

		//stmt.addBatch("insert into employee(id,fname,lname,sallery,dept_id)values(32,'naveen','rathor',10000,4)");
		//int[] count = stmt.executeBatch();
		//System.out.println("data is succesfully inter");
	//}
//}
	PreparedStatement ps=con.prepareStatement("insert into employee values (?,?,?,?,?)");
	ps.setInt(1, 35);
	ps.setString(2, "sonu");
	ps.setString(3, "rat");
	ps.setInt(4, 40000);
	ps.setInt(5, 1);
	ps.addBatch();
	 int[] count=ps.executeBatch();
	 System.out.println("succes");
	}
}
