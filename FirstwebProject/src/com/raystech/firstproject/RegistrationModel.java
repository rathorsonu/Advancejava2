package com.raystech.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationModel {

	public static void Add(RegistrationBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into registration value(?,?,?,?,?,?,?)");

		ps.setString(1, bean.getName());
		ps.setString(2, bean.getSurname());
		ps.setString(3, bean.getGender());
		ps.setDate(4, new java.sql.Date(bean.getDate_of_birth().getTime()));
		ps.setLong(5, bean.getMobile_no());
		ps.setString(6, bean.getEmail());
		ps.setString(7, bean.getPwd());
		ps.execute();
		con.close();
		ps.close();
	}

	public RegistrationBean Authenticate(String login, String pwd) throws Exception {

		RegistrationBean bean = null;

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT name FROM registration WHERE email=? AND pwd=? ");
		ps.setString(1, login);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new RegistrationBean();
			bean.setName(rs.getString(1));

		}
		return bean;

	}

		public RegistrationBean forgetpwd(String login) throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
       RegistrationBean bean=null;
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
			PreparedStatement ps = conn.prepareStatement("SELECT pwd from registration WHERE email=?");
          ps.setString(1, login);
           ResultSet rs=ps.executeQuery();
           while (rs.next()) {
        	   bean=new RegistrationBean();
        	  bean.setPwd(rs.getString(1)); ;
			
		}
           conn.close();
           ps.close();
           return bean;
		}
	
}  
