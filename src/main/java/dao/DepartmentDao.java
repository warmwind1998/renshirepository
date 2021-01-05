package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Department;
import entity.User;

public interface DepartmentDao {
	
	@Select("select * from department")
	public List<Department> selectAll();
	@Select("select * from department where id=#{id}")
	public User selectByid(int id);
	@Select("insert into department(name) values(#{name})")
	public void insert(Department d);
	@Select("delete from department where id=#{id}")
	public void delete(int id);
	@Select("update department set name=#{name} where id=#{id}")
	public void update(Department d);
	
}
