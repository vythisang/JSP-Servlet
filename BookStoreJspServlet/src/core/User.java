package core;

import java.util.Date;

public class User {

	private int id;
	private String email;
	private String password;
	private String name;
	private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public User( int id,String email, String password, String name, Date dob) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.dob = dob;
	}
	
	public User( String email, String password, String name, Date dob) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.dob = dob;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
