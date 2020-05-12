package com.cubit.it.servlet;

import java.time.LocalTime;

public class Utils {
	public static  long currentTime() {
		 //Write logic here
		 LocalTime localTime =LocalTime.now();
		  long cTime =localTime.getHour()*60*60*1000+localTime.getMinute()*60*1000+localTime.getSecond()*1000;
		  return cTime;
	}

}
