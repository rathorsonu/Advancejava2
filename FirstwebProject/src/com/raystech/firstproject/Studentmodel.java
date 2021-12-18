package com.raystech.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Studentmodel {
	public static void main(String[] args) {
		// Delete();
		// Update();
		// GetRoll();
		// Serchlist();

	}

	public Studentbean Serchlist(String bean) throws Exception {
		Studentbean bean1=new Studentbean();
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement(" select*from Studentmgt ");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getString(2));
			bean1.setFirstName(rs.getString(3));
			bean1.setLastName(rs.getString(4));
		    bean1.setSession(rs.getString(5));
		
			}
		
		return bean1;
		
	

	}

	public Studentbean GetRoll(String RollNo)throws Exception {
		Studentbean bean= new Studentbean();
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement("Select Id,FirstName,LastName,Session from Studentmgt where RollNo=?");
		ps.setString(1, RollNo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean.setId(rs.getInt(1));
		    bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
		    bean.setSession(rs.getString(4));
		}
		return bean;
		
	}

	public static void Update(Studentbean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement("Update Studentmgt Set RollNo=?, FirstName=?,LastName=?,Session=?, where Id=? ");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getFirstName());
		ps.setString(4, bean.getLastName());
		ps.setString(5, bean.getSession());
		
     int i=ps.executeUpdate();
     System.out.println(i);
	}

	public static void Delete(Studentbean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement("Delete From Studentmgt where Id=? ");
		ps.setInt(1, bean.getId());
		int i=ps.executeUpdate();

	}

	public static void Add(Studentbean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement("Insert into Studentmgt values(?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getFirstName());
		ps.setString(4, bean.getLastName());
		ps.setString(5, bean.getSession());

		int sd = ps.executeUpdate();
		ps.close();
		conn.close();
		System.out.println("ffffhgfhgh");
	}

}
