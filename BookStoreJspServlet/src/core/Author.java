package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Author {

	private int id;
	private String name;
	private Date dob;
	private int sold_number;
	
	public int getSold_number() {
		return sold_number;
	}
	public void setSold_number(int sold_number) {
		this.sold_number = sold_number;
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

	
	public Author(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
