package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import entity.User;

public interface UserDao extends BasicDao<User>{
	
	@Select("select user.*,department.name department_name from user inner join department on user.department_id=department.id ${where}${limit}")
	public List<User> selectAll(@Param("where") String where,@Param("limit") String limit);
	@Select("select * from user where id=#{id}")
	public User selectByid(int id);
	@Select("insert into user(name,sex,department_id) values(#{name},#{sex},#{department_id})")
	public void insert(User u);
	@Select("delete from user where id=#{id}")
	public void delete(int id);
	@Select("update user set name=#{name},sex=#{sex},department_id=#{department_id} where id=#{id}")
	public void update(User u);
	
}
