package com.cubit.it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.dao.CubicDao;
import com.cubit.it.dao.CubicDaoImpl;
import com.cubit.it.entity.UserEntity;


//This is unique name given to the servlet
@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String searchText=req.getParameter("searchText");
		CubicDao cubicDao =new CubicDaoImpl();
		
		List<UserEntity>  userList=cubicDao.searchUser(searchText);
		req.setAttribute("mark",userList);
    	req.getRequestDispatcher("users.jsp").forward(req, resp);
	}
}
