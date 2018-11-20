package core;

public class Book {

	private int id;
	private String name;
	private int sold_number;
	private double price;
	private Category category;
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
	public int getSold_number() {
		return sold_number;
	}
	public void setSold_number(int sold_number) {
		this.sold_number = sold_number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Book(int id, String name, int sold_number, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.sold_number = sold_number;
		this.price = price;
		this.category = category;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String name, int sold_number, double price, Category category) {
		super();
		
		this.name = name;
		this.sold_number = sold_number;
		this.price = price;
		this.category = category;
	}
	
}
