package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Category;
import dbConnection.DBConnection;

public class CategoryDao {

	
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
	
	
	public ArrayList<Category> displayCategoryList()throws SQLException{
		String query ="select * from bs_category";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ResultSet resultSet = ptmt.executeQuery();
		ArrayList<Category> list = new ArrayList<>();
		while(resultSet.next()){
			Category category = new Category(resultSet);
			list.add(category);
		}
		return list;
	}
	
	
	public boolean addNewCategory(Category category)throws SQLException{
		String query="insert into bs_category(name) values(?)";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setString(1, category.getName());
		int n = ptmt.executeUpdate();
		if(n!=0){
			return true;
		}
		return false;
	}
	
	
	public boolean deleteCategory(int id)throws SQLException{
		String query = "delete from bs_category where id=?";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setInt(1, id);
		int n = ptmt.executeUpdate();
		if(n!=0){
			return true;
		}
		return false;
	}
	
	
	public Category getCategory(int id)throws SQLException{
		String query = "select * from bs_category where id = ?";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			Category category = new Category(rs);
			return category;
		}
		return null;
	}
	
	
	public boolean updateCategory(Category category)throws SQLException{
		String query  = "update bs_category set name = ? where id = ?";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setString(1, category.getName());
		ptmt.setInt(2, category.getId());
		int n = ptmt.executeUpdate();
		if(n!=0){
			return true;
		}
		return false;
	}
	
	
	public ArrayList<Category> getCategory3TopList(){
		ArrayList<Category> categoryList = new ArrayList<>();
		try{
			String query = "select bs_category.id ,bs_category.name ,sum(bs_book.sold_number) as sl "
						+" from bs_category join bs_book on bs_category.id = bs_book.category_id"
						+" group by bs_category.id order by sl desc limit 0,3";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int amount = rs.getInt("sl");
				Category category = new Category(id, name);
				category.setSoldNumber(amount);
				categoryList.add(category);
			}
			return categoryList;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<Category> getCategory3TopRevenueList(){
		ArrayList<Category> categoryList = new ArrayList<>();
		try{
			String query = "select bs_category.id ,bs_category.name ,sum(bs_book.sold_number*price) as revenue from bs_category join bs_book on bs_category.id = bs_book.category_id"
							+" group by bs_category.id order by revenue desc limit 0,3";	
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double revenue = rs.getDouble("revenue");
				Category category = new Category(id, name);
				category.setRevenue(revenue);
				categoryList.add(category);
			}
			return categoryList;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
