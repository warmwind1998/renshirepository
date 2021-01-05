package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface BasicDao <T>{
   public List<T> selectAll(@Param("where") String where,@Param("limit")String limit);
	
	public T selectById(int id);
	
	public void insert(T u);
	
	public void delete(int id);
	
	public void update(T u );
	
	
	
}
