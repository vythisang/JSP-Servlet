package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Book;
import core.Category;
import dbConnection.DBConnection;

public class BookDao {

private Connection conn;

	private CategoryDao categoryDao = new CategoryDao();
	
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
	
	public ArrayList<Book> getBookList()
	{	
		ArrayList<Book> bookList = new ArrayList<>();
		try{
			String query = "select * from bs_book";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name= rs.getString("name");
				int sold_number = rs.getInt("sold_number");
				double price = rs.getDouble("price");
				Category category = categoryDao.getCategory(rs.getInt("category_id"));
				Book book = new Book(id, name, sold_number, price, category);
				bookList.add(book);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public Book getBook(int id){
		try{
			String query = "select * from bs_book where id= ?";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				Category category = categoryDao.getCategory(rs.getInt("category_id"));
				int sold_number = rs.getInt("sold_number");
				double price = rs.getDouble("price");
				Book book = new Book(id, name, sold_number, price, category);
				return book;
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean deleteBook(int id){
		try{
			String query = "delete from bs_book where id = ?";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setInt(1, id);
			int n = ptmt.executeUpdate();
			if(n!=0){
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	
	public boolean updateBook(Book book){
		try{
			String query = "update bs_book set name=?,category_id=?,sold_number=?,price=? where id=?";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setString(1, book.getName());
			ptmt.setInt(2, book.getCategory().getId());
			ptmt.setInt(3, book.getSold_number());
			ptmt.setDouble(4, book.getPrice());
			ptmt.setInt(5, book.getId());
			int n = ptmt.executeUpdate();
			if(n!=0){
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addNewBook(Book book){
		try{
			String query = "insert into bs_book(name,category_id,sold_number,price) value(?,?,?,?)";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setString(1, book.getName());
			ptmt.setInt(2, book.getCategory().getId());
			ptmt.setInt(3, book.getSold_number());
			ptmt.setDouble(4, book.getPrice());
			int n = ptmt.executeUpdate();
			if(n!=0){
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
