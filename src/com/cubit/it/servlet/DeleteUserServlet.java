package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//This is unique name given to the servlet
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String userid=req.getParameter("userid");
	          	try {
					String sql="delete from users_tbl where userid=?";
					//Loading the Driver
					Class.forName("com.mysql.jdbc.Driver");
					//Creating connection
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
					//compiling the query
					PreparedStatement pstmt=connection.prepareStatement(sql);
					pstmt.setString(1,userid);
					pstmt.executeUpdate();
					//Here I say go to users servlet
					 //users - is logic
					 req.getRequestDispatcher("users").forward(req,resp);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
	}
}
