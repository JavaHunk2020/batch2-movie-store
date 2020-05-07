package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.entity.UserEntity;

@WebServlet("/users")
public class UserDataServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
            	//Fetching all the rows no where class
        		String sql="select uid,userid,password,name,email,mobile,salutation,image,createdate,role from users_tbl";
				//Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				//Creating connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				//fire the  query
				ResultSet rs=pstmt.executeQuery();
				//ResultSet has multiple records
				List<UserEntity> userList=new ArrayList<>(); 
				while(rs.next()) {
					//public UserEntity(String userid, String password, String email, String name, String mobile, String image,String salutation) {
					   UserEntity entity=new UserEntity(rs.getString(2),rs.getString(3), 
							   rs.getString(5),rs.getString(4), rs.getLong(6)+"",rs.getString(8),rs.getString(7));
					   //Setting the uid
					   entity.setUid(rs.getInt(1));
					   entity.setCreateDate(rs.getTimestamp(9));
					   entity.setRole(rs.getString(10));
					   userList.add(entity);
				}
				//Adding List into request scope against key "mark"
				//using 
            	req.setAttribute("mark",userList);
            	req.getRequestDispatcher("users.jsp").forward(req, resp);
            }catch (Exception e) {
            	e.printStackTrace();
			}
	}
}
