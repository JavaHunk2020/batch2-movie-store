package com.cubit.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//This is unique name given to the servlet
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
							HttpSession session=req.getSession(false);
							if(session!=null) {
								//Kill the session since we do not need it
								session.invalidate();
							}
						 req.setAttribute("msg", "You have successfully logout!!!!!!!!!!!!!!!!!!!!!!!!");	
						 req.getRequestDispatcher("index.jsp").forward(req,resp);
	}
}
