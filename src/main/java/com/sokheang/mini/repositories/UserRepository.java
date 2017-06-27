package com.sokheang.mini.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sokheang.mini.model.User;

@Repository
public interface UserRepository {
	@Select("SELECT id,username,email,gender,phonenumber,status,user_hash FROM users ORDER BY id")
	public List<User> getAllUser();
	
	@Select("SELECT id,username,email,gender,phonenumber,status FROM users WHERE user_hash=#{user_hash}")
	public User getUserProfile(@Param("user_hash") String user_hash);
	
	/**
	 * Insert data to database
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users(username,email,gender,phonenumber,status,user_hash)"
			+ " VALUES("
			+ " #{user.username},"
			+ " #{user.email},"
			+ " #{user.gender},"
			+ " #{user.phonenumber},"
			+ " #{user.status},"
			+ "	#{user.user_hash} "
			+ ")")
	public boolean addUser(@Param("user") User user);
	
	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean deleteUser(@Param("user_hash") String user_hash);
	
	@Update("UPDATE users SET"
			+ " username = #{user.username},"
			+ " email = #{user.email},"
			+ " gender = #{user.gender},"
			+ " phonenumber = #{user.phonenumber},"
			+ " status = #{user.status}"
			+ " WHERE user_hash = #{user.user_hash}")
	public boolean updateUser(@Param("user") User user);
	
	@Select("SELECT count(*) FROM users")
	public int countUser();
	
	@Select("SELECT count(gender) FROM users WHERE gender='M'")
	public int countMale();
	
	@Select("SELECT count(gender) FROM users WHERE gender='F'")
	public int countFemale();
	
	@Select("SELECT count(status) FROM users WHERE status='Y'")
	public int countActive();
	
}