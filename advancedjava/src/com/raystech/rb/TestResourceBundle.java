package com.raystech.rb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {
	
public static void main(String[] args) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.add",new Locale("hi"));
//	Class.forName(rb.getString("driver"));
//Connection con=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("pwd"));
		
	System.out.println(rb.getString("greeting"));
	//con.close();
}
}
