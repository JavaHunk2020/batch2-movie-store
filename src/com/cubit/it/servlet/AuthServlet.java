package com.cubit.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//This is unique name given to the servlet
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String username=req.getParameter("username");
	              String password=req.getParameter("password");
	              if("jack".equalsIgnoreCase(username) && "jill".equalsIgnoreCase(password)) {
	            	  req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
	              }else {
	            	  req.getRequestDispatcher("fail.jsp").forward(req,resp);
	              }
	}
}
