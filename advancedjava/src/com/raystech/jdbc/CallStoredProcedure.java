package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.sound.sampled.Control.Type;

public class CallStoredProcedure {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunraystech","root","root");
	CallableStatement ps=con.prepareCall("{CALL emp_count(?)}");
	ps.registerOutParameter(1, Types.INTEGER);
	ps.execute();
	int count=ps.getInt(1);
	System.out.println("count  "+count);
}
}
