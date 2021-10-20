package com.mayank.mymodule;


import java.sql.*;
public class Conn {
	
	Connection con ;
	Statement pst;
	
	public Conn() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306","root","Mishank");
			pst = con.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
