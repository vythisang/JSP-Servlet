package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {

	private int id;
	private String name;
	private int soldNumber;
	private double revenue;
	
	
	public int getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(ResultSet resultSet)throws SQLException
	{
		this.id = resultSet.getInt("id");
		this.name= resultSet.getString("name");
	}
}
