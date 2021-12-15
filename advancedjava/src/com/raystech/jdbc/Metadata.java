package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Metadata {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet sd = stmt.executeQuery("select id ,fname,lname from employee");
	ResultSetMetaData rs=sd.getMetaData();
	System.out.println("catlog-->"+rs.getCatalogName(1));//Database name
	System.out.println("table name-->"+rs.getTableName(1));//table name
	int columnCount=rs.getColumnCount();
	System.out.println("total columns-->"+columnCount);//column Total
	for (int i = 1; i <= columnCount; i++) {
		System.out.println("columncount-->"+(i));
		System.out.println("label-->"+rs.getColumnLabel(i));
		System.out.println("name-->"+rs.getColumnType(i));
		System.out.println("sige-->"+rs.getColumnDisplaySize(i));
		System.out.println("precision-->"+rs.getPrecision(i));
		
		
		
		
	}
}
}
