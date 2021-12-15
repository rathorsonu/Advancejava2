package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPrepared {
public static void main(String[] args) throws Exception {
	//Addinsert();
	//Addupdate();
	//adddelete();
	addselect();
}


public static void addselect() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	Statement stmt=con.createStatement();
	PreparedStatement PS=con.prepareStatement("SELECT * FROM EMPLOYEE");
	ResultSet i=PS.executeQuery();
	while (i.next()) {
		System.out.print(i.getInt(1));
		System.out.print("\t" + i.getString(2));
		System.out.print("\t" + i.getString(3));
		System.out.print("\t" + i.getInt(4));
		System.out.println("\t" + i.getInt(5));

		
	}
	

	
}


public static void adddelete() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	Statement stmt=con.createStatement();
	int ID=15;
	PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
	ps.setInt(1, ID);
	int i=ps.executeUpdate();
	System.out.println("delete");
	stmt.close();
	con.close();
}


public static void Addupdate() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	Statement stmt=con.createStatement();
	
	int id=15;
	String fname="navneet";
	String lname="sukla";
	int sallery=30000;
	int dept_id=1;
	PreparedStatement ps=con.prepareStatement("UPDATE EMPLOYEE SET fname=?,lname=?,sallery=?,Dept_ID=? where ID=?");
	ps.setInt(1, id);
	ps.setString(2, fname);
	ps.setString(3, lname);
	ps.setInt(4, sallery);
	ps.setInt(5, dept_id);
	int s=ps.executeUpdate();
	System.out.println("update");
	stmt.close();
	con.close();
	
}

public static void Addinsert() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
	Statement stmt = con.createStatement();
	int id=16;
	String fname="harsh";
	String lname="Rathor";
	int sallery=15000;
	int did=2;
	PreparedStatement ps=con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
	ps.setInt(1, id);
	ps.setString(2, fname);
	ps.setString(3, lname);
	ps.setInt(4, sallery);
	ps.setInt(5, did);
int i=	ps.executeUpdate();
System.out.println("insert");
stmt.close();
con.close();
}

	
	
}

