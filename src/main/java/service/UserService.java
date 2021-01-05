package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import entity.User;

public interface UserService {    
	public List<User> queryAll(@Param("where") String where,@Param("limit") String limit);
	public User selectByid(int id);
	public void insert(User u);
	public void delete(int id);
	public void update(User u);
}
