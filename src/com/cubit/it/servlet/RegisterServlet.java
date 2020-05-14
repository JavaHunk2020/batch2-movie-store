package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.entity.UserEntity;
import com.cubit.it.utils.SQLConnUtil;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			String name=req.getParameter("name");
			String mobile=req.getParameter("mobile");
			String image=req.getParameter("image");
			String salutation=req.getParameter("salutation");
			UserEntity entity=new UserEntity(username,password,email,name,mobile,image,salutation);
			//Write JDBC Code to save all the data into database
			try {
				String sql="INSERT INTO users_tbl(userid,password,name,email,mobile,salutation,image,createdate) values(?,?,?,?,?,?,?,?)";
				Connection connection=SQLConnUtil.getConnection();
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				pstmt.setString(1,entity.getUserid());
				pstmt.setString(2,entity.getPassword());
				pstmt.setString(3,entity.getName());
				pstmt.setString(4,entity.getEmail());
				pstmt.setLong(5,Long.parseLong(entity.getMobile()));
				pstmt.setString(6,entity.getSalutation());
				pstmt.setString(7,entity.getImage());
				//Setting Timestamp
				Timestamp timestamp=new Timestamp(new Date().getTime());
				pstmt.setTimestamp(8,timestamp);
				//FIRE THE QUERY
				int rows=pstmt.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
					
			req.setAttribute("message", "You have successfully registered with us!!!!!!");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
	}

}
