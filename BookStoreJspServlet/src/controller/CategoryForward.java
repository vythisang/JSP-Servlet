package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Category;
import dao.CategoryDao;	

@WebServlet("/CategoryForward")
public class CategoryForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao = new CategoryDao();
	
	
	
    public CategoryForward() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command==null){
			command="LIST";
		}
		switch (command) {
		case "LIST":
			getCategoryList(request, response);
			break;
		
		case "NEW":
			getNewCategory(request, response);
			break;
		
		case "DELETE":
			deleteCategory(request,response);
			break;
		
		case "MODIFY":
			modifyCategory(request, response);
			break;
		
		case "TOP3":
			getCategory3TopList(request,response);
			break;
			
		case "TOP3REVENUE":
			displayCategory3TopRevenueList(request,response);
			break;
		default:
			
			getCategoryList(request, response);
		}
	
	}
	
	
	public void getCategoryList(HttpServletRequest request,HttpServletResponse response){
		try {
			ArrayList<Category> categoryList = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getNewCategory(HttpServletRequest request,HttpServletResponse response){
		try {
			String name = request.getParameter("name");
			Category category = new Category();
			category.setName(name);
			categoryDao.addNewCategory(category);
			ArrayList<Category> categoryList = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteCategory(HttpServletRequest request,HttpServletResponse response){
		try{
			String id = request.getParameter("id");
			categoryDao.deleteCategory(Integer.parseInt(id));
			ArrayList<Category> categoryList = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void modifyCategory(HttpServletRequest request,HttpServletResponse response){
		String id  = request.getParameter("id");
		String name = request.getParameter("newname");
		Category category = new Category(Integer.parseInt(id), name);
		try{
			categoryDao.updateCategory(category);
			ArrayList<Category> categoryList = categoryDao.displayCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getCategory3TopList(HttpServletRequest request,HttpServletResponse response){
		try {
			ArrayList<Category> categoryList = categoryDao.getCategory3TopList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayCategory3TopRevenueList(HttpServletRequest request,HttpServletResponse response){
		try{
			ArrayList<Category> categoryList = categoryDao.getCategory3TopRevenueList();
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("View/Category/DisplayBookCategory.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
