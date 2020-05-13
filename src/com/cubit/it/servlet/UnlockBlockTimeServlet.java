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

@WebServlet("/unlockBlockTime")
public class UnlockBlockTimeServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String tid=req.getParameter("tid");
		  try {
				//Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				//Creating connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
				String sql="update open_time_tbl set active='Yes' where tid = "+Integer.parseInt(tid);
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				pstmt.executeUpdate();
				
				String nosql="update open_time_tbl set active='No' where tid <> "+Integer.parseInt(tid);
				pstmt=connection.prepareStatement(nosql);
				pstmt.executeUpdate();
				//Here I say go to users servlet
				//Now Forward request to blockTime Servlet to show fresh data from the data 
				 req.getRequestDispatcher("blockTime").forward(req,resp);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}

}
