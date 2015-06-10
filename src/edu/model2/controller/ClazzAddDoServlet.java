package edu.model2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.model2.bean.*;

public class ClazzAddDoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ClazzAddDoServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");

		Clazz clazz = new Clazz();
		ClazzDao dao = new ClazzDao();

		clazz.setClazzName(request.getParameter("clazzName"));
		clazz.setClazzCode(request.getParameter("clazzCode"));

		int res;
		
		//拿不到值返回0
		res = dao.addClazz(clazz);

		if (res == 0) {
			request.setAttribute("errMsg", "Add User Failure");
			request.setAttribute("clazz", clazz);
			request.getRequestDispatcher("ClazzAdd.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("ClazzList");
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
