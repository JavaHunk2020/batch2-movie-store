package com.cubit.it.listener;

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
		   System.out.println("****************************************************");
		   System.out.println("*********Application is Up and Running now***********");
		   //But we can write code to send sms
		   //ServletContext is called ApplicationScope
		   //and what ever data you will add here . it will be accessible to every resources
		  ServletContext context= sce.getServletContext();
		  context.setAttribute("email", "cubicsales@cubicit.com");
		  context.setAttribute("address", "CA100, Dalas ,0292");
		   System.out.println("****************************************************");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
