package com.cubit.it.dao;

import java.util.List;

import com.cubit.it.entity.BlockTimeEntity;
import com.cubit.it.entity.UserEntity;

public interface CubicDao {

	public UserEntity authUser(String username, String password);

	List<BlockTimeEntity> findBlockTimes();

	void deleteUserByUserid(String userid);

	String forgetPassword(String email);

	public  List<UserEntity>  searchUser(String searchText);

}
