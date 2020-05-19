package com.cubit.it.servlet.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.dao.CubicDao;
import com.cubit.it.dao.CubicDaoImpl;
import com.cubit.it.entity.UserEntity;
import com.google.gson.Gson;


//This is unique name given to the servlet
@WebServlet("/searchJsonUser")
public class SearchJsonUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String searchText=req.getParameter("searchText");
		CubicDao cubicDao =new CubicDaoImpl();
		List<UserEntity>  userList=cubicDao.searchUser(searchText);
		
		Gson gson=new Gson();
		String jsonString = gson.toJson(userList); // converts to json
		/*req.setAttribute("mark",userList);
    	req.getRequestDispatcher("users.jsp").forward(req, resp);*/
		resp.setContentType("application/json");
		 PrintWriter body=resp.getWriter();
		 body.println(jsonString);
	}
}
