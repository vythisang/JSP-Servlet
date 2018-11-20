package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Book;
import core.Category;
import dao.BookDao;
import dao.CategoryDao;
@WebServlet("/BookForward")
public class BookForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDao bookDao = new BookDao();
    private CategoryDao categoryDao = new CategoryDao();
    public BookForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		if(command == null){
			command="LIST";
		}
		
		switch (command) {
		case "LIST":
			displayBook(request,response);
			break;
			
		case "DELETE":
			deleteBook(request,response);
			break;
		
		case "MODIFY":
			modifiBook(request,response);
			break;
			
		case "NEW":
			addNewBook(request,response);
			break;
		default:
			displayBook(request,response);
			break;
		}
		
		
		
	}
	
	
	public void deleteBook(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		try{
			bookDao.deleteBook(Integer.parseInt(id));
			ArrayList<Book> bookList=  bookDao.getBookList();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("View/Book/DisplayBook.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void displayBook(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Book> bookList=  bookDao.getBookList();
		request.setAttribute("bookList", bookList);
		try{
			request.getRequestDispatcher("View/Book/DisplayBook.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void modifiBook(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Category category = categoryDao.getCategory(Integer.parseInt(request.getParameter("category")));
			int sold_number = Integer.parseInt(request.getParameter("sold_number"));
			double price  = Double.parseDouble(request.getParameter("price"));
			Book newBook = new Book(id, name, sold_number, price, category);
			bookDao.updateBook(newBook);
			ArrayList<Book> bookList=  bookDao.getBookList();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("View/Book/DisplayBook.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void addNewBook(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			String name = request.getParameter("name");
			Category category = categoryDao.getCategory(Integer.parseInt(request.getParameter("category")));
			int sold_number = Integer.parseInt(request.getParameter("sold_number"));
			double price = Double.parseDouble(request.getParameter("price"));
			Book book = new Book(name, sold_number, price, category);
			bookDao.addNewBook(book);
			ArrayList<Book> bookList=  bookDao.getBookList();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("View/Book/DisplayBook.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
