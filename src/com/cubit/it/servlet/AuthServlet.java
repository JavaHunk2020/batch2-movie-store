package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.entity.UserEntity;


//This is unique name given to the servlet
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String username=req.getParameter("username");
	              String password=req.getParameter("password");
	          	try {
					String sql="select uid,userid,password,name,email,mobile,salutation,image,createdate from users_tbl where userid=? and password= ?";
					//Loading the Driver
					Class.forName("com.mysql.jdbc.Driver");
					//Creating connection
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
					//compiling the query
					PreparedStatement pstmt=connection.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,password);
					ResultSet rs=pstmt.executeQuery();
					//uid,userid,password,name,email,mobile,salutation,image,createdate 
					if(rs.next())  {
						//public UserEntity(String userid, String password, String email, String name, String mobile, String image,String salutation) {
						   UserEntity entity=new UserEntity(rs.getString(2),rs.getString(3), 
								   rs.getString(5),rs.getString(4), rs.getLong(6)+"",rs.getString(7),rs.getString(8));
						   entity.setUid(rs.getInt(1));
						   entity.setCreateDate(rs.getTimestamp(9));
						   
						   //Here we are adding this data to show on review page
						   req.setAttribute("pdata", entity);
						 
						   req.getRequestDispatcher("review.jsp").forward(req,resp);
					}else {
						 req.getRequestDispatcher("fail.jsp").forward(req,resp);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
	}
}
