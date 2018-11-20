package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Author;
import dao.AuthorDao;
@WebServlet("/AuthorForward")
public class AuthorForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthorDao authorDao = new AuthorDao();   
	
    public AuthorForward() {
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
			displayAuthorList(request,response);
			break;
		
		case "NEW":
			addNewAuthor(request,response);
			break;
		
		case "DELETE":
			deleteAuthor(request,response);
			break;
		
		case "MODIFY":
			modifyAuthor(request,response);
			break;
			
		case "TOP3REVENUE":
			display3TopAuthorList(request,response);
			break;
		default:
			displayAuthorList(request,response);
			break;
		}
		
		
		
	
	
	}
	
	public void displayAuthorList(HttpServletRequest request, HttpServletResponse response){
		try{
			ArrayList<Author> authorList= authorDao.getAuthorList();
			request.setAttribute("authorList", authorList);
			request.getRequestDispatcher("View/Author/DisplayAuthor.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNewAuthor(HttpServletRequest request, HttpServletResponse response){
		try{
			String name = request.getParameter("name");
			String strDob = request.getParameter("dob");
			Author author = new Author();
			author.setName(name);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = sdf.parse(strDob);
			author.setDob(dob);
			authorDao.addNewAuthor(author);
			ArrayList<Author> authorList= authorDao.getAuthorList();
			request.setAttribute("authorList", authorList);
			request.getRequestDispatcher("View/Author/DisplayAuthor.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteAuthor(HttpServletRequest request, HttpServletResponse response){
		try{
			String id = request.getParameter("id");
			authorDao.deleteAuthor(Integer.parseInt(id));
			ArrayList<Author> authorList= authorDao.getAuthorList();
			request.setAttribute("authorList", authorList);
			request.getRequestDispatcher("View/Author/DisplayAuthor.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifyAuthor(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String strDob = request.getParameter("dob");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Author author = new Author(Integer.parseInt(id), name, sdf.parse(strDob));
			authorDao.modify(author);
			ArrayList<Author> authorList= authorDao.getAuthorList();
			request.setAttribute("authorList", authorList);
			request.getRequestDispatcher("View/Author/DisplayAuthor.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void display3TopAuthorList(HttpServletRequest request, HttpServletResponse response){
		try{
			ArrayList<Author> authorList= authorDao.getAuthorRevenue3TopList();
			request.setAttribute("authorList", authorList);
			request.getRequestDispatcher("View/Author/DisplayAuthor.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
