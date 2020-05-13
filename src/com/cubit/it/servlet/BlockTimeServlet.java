package com.cubit.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubit.it.entity.BlockTimeEntity;

@WebServlet("/blockTime")
public class BlockTimeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
            	//Fetching all the rows no where class
        		String sql="select tid,startTime,endTime,active from open_time_tbl";
				//Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				//Creating connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				//fire the  query
				ResultSet rs=pstmt.executeQuery();
				//ResultSet has multiple records
				List<BlockTimeEntity> blockTimeList=new ArrayList<>(); 
				while(rs.next()) {
					    int tid=rs.getInt(1);
					    Time startTime=rs.getTime(2);
					    Time endTime=rs.getTime(3);
					    String active=rs.getString(4);
					    BlockTimeEntity blockTimeEntity=new BlockTimeEntity();
					    blockTimeEntity.setActive(active);
					    blockTimeEntity.setEndTime(endTime);
					    blockTimeEntity.setStartTime(startTime);
					    blockTimeEntity.setTid(tid);
					    blockTimeList.add(blockTimeEntity);
				}
				//Adding List into request scope against key "blockTimeList"
				//using 
            	req.setAttribute("blockTimeList",blockTimeList);
            	req.getRequestDispatcher("blockTime.jsp").forward(req, resp);
            }catch (Exception e) {
            	e.printStackTrace();
			}
	}
}
