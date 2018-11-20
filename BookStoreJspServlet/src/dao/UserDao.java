package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import core.User;
import dbConnection.DBConnection;

public class UserDao {

	private Connection conn;
	
	private static Connection getConnection(){
		return DBConnection.getDBConnection().getConn();
	}
	
	public void close(){
		try{
			if(conn!=null){
				conn.close();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public  User findUser(String email,String password)throws SQLException{
		
		String query = "select * from bs_user where email=? and password=?";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setString(1, email);
		ptmt.setString(2, password);
		ResultSet resultSet = ptmt.executeQuery();
		if(resultSet.next()){
			int id = resultSet.getInt("id");
			String getEmail = resultSet.getString("email");
			String passwd = resultSet.getString("password");
			String name = resultSet.getString("name");
			Date dob = resultSet.getDate("dob");
			User user = new User(id, getEmail, passwd, name, dob);
			return user;
		}
		return null;
	}
	
	
	public boolean addUser(User user) throws SQLException{
		String query = "insert into bs_user(email,name,password,dob) values(?,?,?,?)";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setString(1, user.getEmail());		
		ptmt.setString(2, user.getName());
		ptmt.setString(3, user.getPassword());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ptmt.setDate(4, java.sql.Date.valueOf(sdf.format(user.getDob())));
		int n = ptmt.executeUpdate();
		if(n!=0){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
