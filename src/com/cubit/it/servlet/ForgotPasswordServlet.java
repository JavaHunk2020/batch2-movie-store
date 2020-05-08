package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//This is unique name given to the servlet
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String email=req.getParameter("email");
	          	try {
					//Loading the Driver
					Class.forName("com.mysql.jdbc.Driver");
					//Creating connection
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
					String sql="select password from users_tbl where email=?";
					//compiling the query
					PreparedStatement pstmt=connection.prepareStatement(sql);
					pstmt.setString(1,email);
					
					//We use executeQuery only for select
					ResultSet rs=pstmt.executeQuery();
					if(rs.next())  {
						   String password=rs.getString(1);
						   //request scope is used to carry from servlet to JSP
						   req.setAttribute("password","Hello , Your password is  =  "+ password);
						   req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
					}else {
						   req.setAttribute("msg", "Sorry, your email id is not correct!!!");
						   req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
	}
}
