package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Category;
import dao.CategoryDao;
@WebServlet("/ModifyCategory")
public class ModifyCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao = new CategoryDao();   
	
    public ModifyCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("View/Category/AddNewCategory.jsp").forward(request, response);
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try{
			
			Category category = categoryDao.getCategory(Integer.parseInt(id));
			request.setAttribute("category", category);
			request.getRequestDispatcher("View/Category/UpdateCategory.jsp").forward(request, response);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();;
		}
	}
}
