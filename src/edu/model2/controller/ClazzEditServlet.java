package edu.model2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.model2.bean.Clazz;
import edu.model2.bean.ClazzDao;

public class ClazzEditServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ClazzEditServlet() {
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
		//
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
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

		// 这个编码格式控制一定要放在要放在PrintOut
		// out =response.getWriter()代码的前面，
		// 否则只是有告诉客户端用什么码表编码的功能，而服务器端还是用ISO-8859-1编码了
		//网页乱码表现为：全为？？？？？？？？？？？？？？
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Clazz clazz = new Clazz();
		ClazzDao dao = new ClazzDao();
		try {
			clazz = dao.findClazzById(Integer.parseInt(request
					.getParameter("clazzId")));
		} catch (Exception e) {
			out.print(e);
		}
		request.setAttribute("clazz", clazz);
		request.getRequestDispatcher("ClazzEditDo.jsp").forward(request,
				response);

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
