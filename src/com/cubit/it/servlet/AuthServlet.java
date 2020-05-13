package com.cubit.it.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cubit.it.entity.UserEntity;


//This is unique name given to the servlet
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	              String username=req.getParameter("username");
	              String password=req.getParameter("password");
	          	try {
					String sql="select uid,userid,password,name,email,mobile,salutation,image,createdate,role from users_tbl where userid=? and password= ?";
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
						  UserEntity entity=new UserEntity();
						   int uid=rs.getInt(1);
						   String userid=rs.getString(2);
						   String dpassword=rs.getString(3);
						   String name=rs.getString(4);
						   String email=rs.getString(5);
						   BigDecimal mobile=rs.getBigDecimal(6);
						   String salutation=rs.getString(7);
						   String image=rs.getString(8);
						   Timestamp doe=rs.getTimestamp(9);
						   String role=rs.getString(10);
						   
						   entity.setUid(uid);
						   entity.setUserid(userid);
						   entity.setPassword(dpassword);
						   entity.setName(name);
						   entity.setEmail(email);
						   entity.setMobile(mobile.longValue()+"");
						   entity.setImage(image);
						   entity.setSalutation(salutation);
						   entity.setCreateDate(doe);
						   entity.setRole(role);
						   //Here we are adding this data to show on review page
						   //Creatign session scope for the user
						   //CTR-SHIFT+O
						   HttpSession session=req.getSession();
						   session.setMaxInactiveInterval(30*2*5);
						   //Adding data into session scope instead of request scope
						   session.setAttribute("pdata", entity);
						   req.getRequestDispatcher("review.jsp").forward(req,resp);
					}else {
						 req.getRequestDispatcher("fail.jsp").forward(req,resp);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
	}
}
