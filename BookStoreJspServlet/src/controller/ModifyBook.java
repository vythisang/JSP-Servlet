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

@WebServlet("/ModifyBook")
public class ModifyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();
	private CategoryDao categoryDao  = new CategoryDao();
    public ModifyBook() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<Category> categoryList  = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Book/AddNewBook.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		try{
			Book book = bookDao.getBook(Integer.parseInt(id));
			request.setAttribute("book", book);
			ArrayList<Category> categoryList  = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Book/UpdateBook.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
