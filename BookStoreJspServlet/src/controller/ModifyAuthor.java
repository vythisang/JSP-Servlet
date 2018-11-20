package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Author;
import dao.AuthorDao;
@WebServlet("/ModifyAuthor")
public class ModifyAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthorDao authorDao = new AuthorDao();  
    public ModifyAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("View/Author/AddNewAuthor.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id = request.getParameter("id");
			Author author = authorDao.getAuthor(Integer.parseInt(id));
			request.setAttribute("author", author);
			System.out.println(author.getId()+","+author.getName());
			request.getRequestDispatcher("View/Author/UpdateAuthor.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
