package com.cubit.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubit.it.dao.CubicDao;
import com.cubit.it.dao.CubicDaoImpl;
import com.cubit.it.entity.UserEntity;


//This is unique name given to the servlet
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String username=req.getParameter("username");
	              String password=req.getParameter("password");
	              CubicDao cubicDao=new CubicDaoImpl();
	              UserEntity userEntity=cubicDao.authUser(username, password);
	              if(userEntity!=null)  {
	            	  HttpSession session=req.getSession();
					   session.setMaxInactiveInterval(30*2*5);
					   //Adding data into session scope instead of request scope
					   session.setAttribute("pdata", userEntity);
					   req.getRequestDispatcher("review.jsp").forward(req,resp);  
			 }else {
				 req.getRequestDispatcher("fail.jsp").forward(req,resp);
			 }
	}
}
