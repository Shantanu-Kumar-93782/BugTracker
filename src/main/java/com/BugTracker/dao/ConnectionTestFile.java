package com.BugTracker.dao;

import java.sql.DriverManager;

public class ConnectionTestFile {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/digitalpathshala";
		String userName = "DIGITALPATHSHALA";
		String password = "Steve82395@95216";
		
		try {
			DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection Successful");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
