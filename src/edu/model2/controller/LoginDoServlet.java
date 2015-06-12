package edu.model2.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.model2.bean.User;
import edu.model2.bean.UserDao;

public class LoginDoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginDoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");

		User user= new User();
		UserDao dao = new UserDao();

		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setUserKey(request.getParameter("password"));

		boolean res=false;
		
		
		try {
			if(dao.idExist(user.getUserId())){
				res = dao.loginDo(user.getUserId(), user.getUserKey());
			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if (!res) {
			
			request.setAttribute("errMsg", " 学号或密码错误!请再试一次！");
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
			
		} else {
			
			user=dao.findUserById(user.getUserId());
			
			HttpSession session=request.getSession();
			
			session.setAttribute("userName",
					user.getUserName());
			
			String userName=(String) session.getAttribute("userName");

			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request,
					response);

		}

		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
