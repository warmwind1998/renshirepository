package serviceImpl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.BasicDao;
import utils.SearchInfo;


public class BasicSeviceimpl <T>  {


	private BasicDao<T> getDao(){
		try{
		Field f=this.getClass().getDeclaredField("dao");
		return (BasicDao<T>)f.get(this);
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public List<T> selectAll(SearchInfo info) {
		return getDao().selectAll(info.getWhere(),info.getLimit());
	}

	public T selectById(int id) {
		return getDao().selectById(id);
	}

	public void insert(T u) {
		getDao().insert(u);
	}

	public void delete(int id) {
		getDao().delete(id);
	}

	public void update(T u) {
		getDao().update(u);
	}

}
