package com.cubit.it.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @author nagendra
 * 
 *  @WebListener= > This annotation indicates , Hey I am a not normal class , I am a listener
 */
@WebListener
public class ApplicationStartupListener  implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		 //But we can write code to send sms
		   //ServletContext is called ApplicationScope
		   //and what ever data you will add here . it will be accessible to every resources
		  ServletContext context= sce.getServletContext();
		
	 try {
			 
			 String sql="select startTime,Endtime from open_time_tbl where tid=1";
				//Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				//Creating connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_hrs_db","root","mysql@1234");
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					Time startTime=rs.getTime(1);
 					Time endTime=rs.getTime(2);
					long startTimeInMillis = startTime.getHours()*60*60*1000+startTime.getMinutes()*60*1000+startTime.getSeconds()*1000;
					long endTimeInMillis = endTime.getHours()*60*60*1000+endTime.getMinutes()*60*1000+endTime.getSeconds()*1000;
					context.setAttribute("startTimeInMillis", startTimeInMillis);
					context.setAttribute("endTimeInMillis", endTimeInMillis);
					context.setAttribute("startTime", startTime);
					context.setAttribute("endTime", endTime);
				}
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		   System.out.println("****************************************************");
		   System.out.println("*********Application is Up and Running now***********");
		  
		  context.setAttribute("email", "cubicsales@cubicit.com");
		  context.setAttribute("address", "CA100, Dalas ,0292");
		   System.out.println("****************************************************");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
