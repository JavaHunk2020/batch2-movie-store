package com.cubit.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.dao.CubicDao;
import com.cubit.it.dao.CubicDaoImpl;


//This is unique name given to the servlet
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String email=req.getParameter("email");
			CubicDao cubicDao =new CubicDaoImpl();
			String password=cubicDao.forgetPassword(email);
			if(password!=null) {
				 req.setAttribute("password","Hello , Your password is  =  "+ password);
				   req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
			}else {
				 req.setAttribute("msg", "Sorry, your email id is not correct!!!");
				   req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
			}	
	}
}
