package edu.model2.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.model2.bean.Attendance;
import edu.model2.bean.AttendanceDao;
import edu.model2.bean.ClazzDao;

public class AttendanceAddDoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AttendanceAddDoServlet() {
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

		Attendance at = new Attendance();
		AttendanceDao dao = new AttendanceDao();

		HttpSession hs=request.getSession();
		Integer userId=Integer.parseInt((String)hs.getAttribute("useId"));
		at.setUserId(userId);
		at.setInTime(new Date().toLocaleString());
//		Integer.parseInt(request.getSession().getAttribute("userId"));
//		at.setUserId(Integer.parseInt(request.getSession().getAttribute("userId")));
//		at.setClazzName(request.getParameter("clazzName"));
//		at.setClazzCode(request.getParameter("clazzCode"));

		int res;
		
		//拿不到值返回0
		res = dao.addAttendance(at);

		if (res == 0) {
			request.setAttribute("errMsg", "签到失败");
			request.setAttribute("at", at);
			request.getRequestDispatcher("sign.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("index.jsp");
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
