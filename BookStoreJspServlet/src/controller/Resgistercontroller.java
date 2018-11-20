package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.User;
import dao.UserDao;

@WebServlet("/Resgistercontroller")
public class Resgistercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();  
    public Resgistercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		String name = request.getParameter("name");
		String dob  = request.getParameter("dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user=null;
		try {
			user = new User(email, password, name, sdf.parse(dob));
		
			if(userDao.addUser(user)){
				request.setAttribute("msgregister", "Resgister successful");
				request.getRequestDispatcher("View/Register.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msgregister", "Resgister fail");
				request.getRequestDispatcher("View/Register.jsp").forward(request, response);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
