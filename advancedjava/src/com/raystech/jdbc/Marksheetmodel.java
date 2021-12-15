package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Marksheetmodel {

public static int nextpk(MarksheetBean bean) throws Exception {
	int pk=0;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
	PreparedStatement ps = con.prepareStatement("select max(Id) from marksheet");
	 ResultSet rs=ps.executeQuery();
	 while (rs.next()) {
		  pk=rs.getInt(1);
	}
	 return pk+1;
}
	public void Serch(MarksheetBean bean) throws Exception {
		ResourceBundle rb =ResourceBundle.getBundle("com.raystech.rb.app");
		Class.forName(rb.getString("driver"));
		Connection con = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("pwd"));
	
		PreparedStatement ps = con.prepareStatement("select * from marksheet where Rollno=?");
		ps.setInt(1, bean.getRollno());
		ResultSet sd=ps.executeQuery();
		while (sd.next()) {
			System.out.println("serch");
			System.out.print("\t"+sd.getInt(1));
			System.out.print("\t"+sd.getInt(2));
			System.out.print("\t"+sd.getString(3));
			System.out.print("\t"+sd.getString(4));
			System.out.print("\t"+sd.getInt(5));
			System.out.print("\t"+sd.getInt(6));
			System.out.println("\t"+sd.getInt(5));
		}
		ps.close();
		con.close();
		}
	

		
	


		public void rollno(MarksheetBean bean) throws Exception {
			ResourceBundle rb=ResourceBundle.getBundle("com.raystech.rb.app");
		Class.forName(rb.getString("driver"));
		Connection con = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("pwd"));
		// Statement stmt = con.createStatement();
		PreparedStatement ps = con.prepareStatement("select * from marksheet where rollno=?");
		ps.setInt(1, bean.getRollno());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.print("\t" + rs.getInt(6));
			System.out.println("\t" + rs.getInt(7));

		}
	}

public void marksheet(MarksheetBean bean) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
	//Statement stmt = con.createStatement();
	PreparedStatement ps = con.prepareStatement("select * from marksheet where Rollno=?");
	ps.setInt(1, bean.getRollno());
	ResultSet rs=ps.executeQuery();
	while (rs.next()) {
		
		System.out.print("\t" + rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getString(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.print("\t" + rs.getInt(6));
		System.out.println("\t" + rs.getInt(7));
	}
ps.close();
con.close();

	
	

}
	public void Delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		PreparedStatement ps = con.prepareStatement("delete from marksheet where id =?");
		ps.setInt(1, bean.getId());
		ps.executeUpdate();
		con.close();
		stmt.close();

	}

	public static void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		PreparedStatement ps = con.prepareStatement(
				"update marksheet set rollno=?, firstname=?, lastname=?, physics=?, chemistry=?, mathes=? where id=?");

		ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChe());
		ps.setInt(7, bean.getMath());
		ps.executeUpdate();
		System.out.println("update");
		con.close();
		stmt.close();

	}

	public static void add(MarksheetBean bean) throws Exception {
		ResourceBundle rb=ResourceBundle.getBundle("com.raystech.rb.app");
		Class.forName(rb.getString("driver"));
		Connection con = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("pwd"));
		//Statement stmt = con.createStatement();
		PreparedStatement ps = con.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, nextpk(bean));
		ps.setInt(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChe());
		ps.setInt(7, bean.getMath());

		ps.execute();
		con.close();
		//stmt.close();
	}
}
