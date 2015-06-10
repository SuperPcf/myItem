package edu.model2.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.apache.commons.lang.StringUtils; 



public class IPFilter implements Filter {

	protected FilterConfig filterConfig;
	protected String ip;

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		this.ip = this.filterConfig.getInitParameter("ip");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		String remoteIP=request.getRemoteAddr();
		//String remoteIP=this.getIpAddr((HttpServletRequest)request);
		System.out.println("--------->>>>>>>MyIP:"+remoteIP);
		if(remoteIP.equals(ip)){
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println("<b>该IP地址已经被禁止访问，请联系管理员");
			
		}
		else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}
	/**
	 2      * 获取访问者IP
	 3      * 
	 4      * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 5      * 
	 6      * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
	 7      * 如果还不存在则调用Request .getRemoteAddr()。
	 8      * 
	 9      * @param request
	10      * @return
	11      */
	
	  public static String getIpAddr(HttpServletRequest request) {
   String ip = request.getHeader("X-Real-IP");
    if (StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
           return ip;
        }
    		//需要添加commons-lang-2.5.jar包
         if (StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
	             // 多次反向代理后会有多个IP值，第一个为真实IP。
	             int index = ip.indexOf(',');
	             if (index != -1) {
	                 return ip.substring(0, index);
	            } else {
	                 return ip;
	            }
	         } else {
	            return request.getRemoteAddr();
	        }
	     }
    
}
