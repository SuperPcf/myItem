package edu.model2.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {  
	 
    private String encoding=null;  
    private boolean ignore=true;  
      
    public void destroy() {  
        // TODO Auto-generated method stub  
        encoding=null;  
    }  
 
    /**  
       * 过滤请求，用户提交请求时起作用  
       */    
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        if(ignore||request.getCharacterEncoding()==null){  
            String encoding=getEncoding();  
            if(encoding!=null){  
                request.setCharacterEncoding(encoding);  
            }  
        }  
//      System.out.println("encoding===="+encoding);  
        response.setContentType("text/html;charset="+encoding);  
//      do something here  
        //当前工作全部完成后，将请求放开给过滤器链的下一filter   
        chain.doFilter(request, response);  
    }  
 
    public void init(FilterConfig filterConfig) throws ServletException {  
        // TODO Auto-generated method stub  
        this.encoding=filterConfig.getInitParameter("encoding");  
        String value=filterConfig.getInitParameter("ignore");  
        if(value==null){  
            this.ignore=true;  
        }else if(value.equalsIgnoreCase("true")){  
            this.ignore=true;  
        }else if(value.equalsIgnoreCase("yes")){  
            this.ignore=true;  
        }else{  
            this.ignore=false;  
        }  
    }  
 
    protected String getEncoding(){  
        return this.encoding;  
    }  
} 