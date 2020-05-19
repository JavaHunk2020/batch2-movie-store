package com.cubit.it.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cubit.it.entity.BlockTimeEntity;
import com.cubit.it.entity.UserEntity;
import com.cubit.it.utils.SQLConnUtil;

public class CubicDaoImpl  implements CubicDao {
	
	@Override
	public String  forgetPassword(String email) {
	   String password=null;
       	try {
       		Connection connection=SQLConnUtil.getConnection();
				String sql="select password from users_tbl where email=?";
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				pstmt.setString(1,email);
				//We use executeQuery only for select
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())  {
					    password=rs.getString(1);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
           return password;       	
	}
	
	
	
	@Override
	public void deleteUserByUserid(String userid) {
       	try {
				String sql="delete from users_tbl where userid=?";
				Connection connection=SQLConnUtil.getConnection();
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				pstmt.setString(1,userid);
				pstmt.executeUpdate();
				//Here I say go to users servlet
				 //users - is logic
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	
	@Override
	public List<BlockTimeEntity> findBlockTimes() {
		
		List<BlockTimeEntity> blockTimeList=new ArrayList<>(); 
		 try {
         	//Fetching all the rows no where class
     		String sql="select tid,startTime,endTime,active from open_time_tbl";
     		Connection connection=SQLConnUtil.getConnection();
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				//fire the  query
				ResultSet rs=pstmt.executeQuery();
				//ResultSet has multiple records
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
         }catch (Exception e) {
         	e.printStackTrace();
			}
		  return blockTimeList;
	}
	
	//ALT + LEFT ARROW 
	@Override
	public UserEntity  authUser(String username,String password) {
		
 	  UserEntity entity=null;		
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
				   entity=new UserEntity();
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
			}	 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return entity;
	}


	@Override
	public List<UserEntity> searchUser(String searchText) {
		List<UserEntity> userList=new ArrayList<>(); 
		   try {
           	//Fetching all the rows no where class
       		String sql="select uid,userid,password,name,email,mobile,salutation,image,createdate,role "
       				+ "from users_tbl where name like '%"+searchText+"%'  or email like '%"+searchText+"%'  or userid like '%"+searchText+"%'";
       		Connection connection=SQLConnUtil.getConnection();
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				//fire the  query
				ResultSet rs=pstmt.executeQuery();
				//ResultSet has multiple records
				
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
		   }catch (Exception e) {
			   	e.printStackTrace();
		}		
		return userList;
	}

}
