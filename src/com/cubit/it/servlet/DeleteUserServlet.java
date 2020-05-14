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
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String userid=req.getParameter("userid");
		CubicDao cubicDao =new CubicDaoImpl();
		cubicDao.deleteUserByUserid(userid);
		 req.getRequestDispatcher("users").forward(req,resp);
	}
}
