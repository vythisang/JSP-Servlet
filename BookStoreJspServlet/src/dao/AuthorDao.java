package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import core.Author;
import core.Category;
import dbConnection.DBConnection;

public class AuthorDao {

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
	
	public ArrayList<Author> getAuthorList() {
		ArrayList<Author> authorList  =  new ArrayList<>();
		try{
			String query = "select * from bs_author";
			PreparedStatement ptmt  = getConnection().prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setDob(rs.getDate("dob"));
				authorList.add(author);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return authorList;
	}
	
	
	public boolean addNewAuthor(Author author){
		try{
			String query = "insert into bs_author(name,dob) values(?,?)";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setString(1, author.getName());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ptmt.setDate(2,java.sql.Date.valueOf( sdf.format(author.getDob())));
			int n = ptmt.executeUpdate();
			if(n!=0){
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAuthor(int id){
		try{
			String query = "delete from bs_author where id = ?";
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
	
	public Author getAuthor(int id)throws SQLException{
		String query = "select * from bs_author where id = ?";
		PreparedStatement ptmt = getConnection().prepareStatement(query);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			Author author = new Author();
			author.setName(rs.getString("name"));
			author.setDob(rs.getDate("dob"));
			author.setId(id);
			return author;
		}
		return null;
	}
	
	public boolean  modify(Author author) {
		String query = "update bs_author set name = ?, dob = ? where id = ?";
		try{
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ptmt.setString(1, author.getName());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ptmt.setDate(2, java.sql.Date.valueOf(sdf.format(author.getDob())));
			ptmt.setInt(3, author.getId());
			int n = ptmt.executeUpdate();
			if(n!=0){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	
	public ArrayList<Author> getAuthorRevenue3TopList(){
		ArrayList<Author> authorList = new ArrayList<>();
		try{
			String query = "select bs_author.id,bs_author.name,bs_author.dob,sum(bs_book.sold_number*bs_book.price*bs_author_book.revenue_share) as revenue"
						+" from bs_author join bs_author_book on bs_author.id = bs_author_book.author_id join bs_book on bs_author_book.book_id=bs_book.id"
						+" group by bs_author.id order by revenue desc limit 0,3";
			PreparedStatement ptmt = getConnection().prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setDob(rs.getDate("dob"));
				authorList.add(author);
			}
			return authorList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
