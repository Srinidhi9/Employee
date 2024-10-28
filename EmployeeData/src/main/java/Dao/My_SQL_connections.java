package Dao;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class My_SQL_connections {
	private static String db;
	private static String db_password;
	
	private static My_SQL_connections mysqlconnection = new My_SQL_connections();
	
	Connection connection;
	
	private My_SQL_connections() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter DataBase password of your local : ");
			db_password=sc.next();
			System.out.println("Enter table name : ");
			db=sc.next();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, "root",db_password );
				System.out.println("Connected to table successfully");
				}
			catch(Exception e) {
				System.out.println(e);
				
			}
	}
	public static Connection getInstance() {
		return mysqlconnection.connection;
		
	}
	public static void main(String[] args) {
		System.out.println(My_SQL_connections.getInstance());
	}

}

