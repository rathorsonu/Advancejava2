package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;

public class CAlStoredFunction {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	CallableStatement callstmt=con.prepareCall("{CALL EMP_Count(?,?)}");
	callstmt.registerOutParameter(1, Types.INTEGER);
	callstmt.setString(1, "sonu");
	callstmt.setInt(2, 100);
	callstmt.execute();
	System.out.println("count"+callstmt.getInt(1));
	//System.out.println("count"+callstmt.getInt(1));
	
	
}
}
