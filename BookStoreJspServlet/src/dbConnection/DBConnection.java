package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private Connection conn;
	private static DBConnection db;
	
	
	
	private DBConnection(){
		String driver= "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "book_store";
		String username = "root";
		String password = "admin1234";
		try{
			
			Class.forName(driver).newInstance();
			conn  = DriverManager.getConnection(url+dbName, username, password);
			
		}catch (Exception e) {
			System.out.println("There is an error when connecting database");
		} 
	}
	
	
	public static synchronized DBConnection getDBConnection(){
		if(db == null){
			db = new DBConnection();
		}
		return db;
	}
	
	
	public Connection getConn(){
		return conn;
	}
	
	
	
	
	
	
	
}
