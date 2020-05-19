package com.cubit.it.filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubit.it.servlet.Utils;

//All the incoming request
@WebFilter(value="/*")
public class SessionBlockerFilter implements Filter {
	
	private Set<String> allowedUrls=new HashSet<>();
	
	private  long startTime=18*60*60*1000;
	private  long endTime=19*60*60*1000;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowedUrls.add("/index.jsp");
		allowedUrls.add("/register.jsp");
		allowedUrls.add("/forgotPassword.jsp");
		allowedUrls.add("/auth");
		allowedUrls.add("/register");
		allowedUrls.add("/forgotPassword");
		allowedUrls.add("/unavaliable.jsp");
		allowedUrls.add("/unavaliable.jsp");
		allowedUrls.add("/searchJsonUser");
		
		//Accesing  data 
		ServletContext   se= filterConfig.getServletContext();
		
		//updating default values
		startTime=(long)se.getAttribute("startTimeInMillis");
		endTime=(long)se.getAttribute("endTimeInMillis");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		 //Reference type casting = Downcasting
		 HttpServletRequest httpServletRequest =(HttpServletRequest)request;
		 String resourceName=httpServletRequest.getServletPath();
		 System.out.println("Accessing resource = "+resourceName+" at time  "+LocalDateTime.now());
		 
		 if(resourceName.contains("/img") || resourceName.contains("tjs")) {
			  chain.doFilter(request, response);
		 }
		 else {
				 if(allowedUrls.contains(resourceName)) {
					 //Write logic here
					  long cTime =Utils.currentTime();
					  if(resourceName.equalsIgnoreCase("/unavaliable.jsp")  ||  cTime>startTime && cTime<endTime) {
						  chain.doFilter(request, response);
					  }else {
						   //http://localhost:9999/happy-hours
					       ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath()+"/unavaliable.jsp");
					  }
					
				 }else {
					//checking to see if user is logged in or not
					   HttpSession session=httpServletRequest.getSession(false);
					   if(session!=null &&  session.getAttribute("pdata")!=null)  {
						           chain.doFilter(request, response);
					   }else {
						   	     //http://localhost:9999/happy-hours
						       ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath()+"/index.jsp");
					   }	 
				 }
		}	 
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
