package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;
import utils.SearchInfo;
@Service
public  class UserServiceimpl extends BasicSeviceimpl<User> implements UserService{
    @Autowired
    UserDao dao;
	public List<User> queryAll(SearchInfo info) {
		
		String where="";
		if(info.getInt("id")==0&&info.isNoNull("name")){
			where="where user.name like '%"+info.get("name")+"%'";
		}
		if(info.getInt("id")==1&&info.isNoNull("sex")){
			where="where user.sex="+info.get("sex");
		}
		info.setWhere(where);
		return super.selectAll(info);
	}

	public User selectByid(int id) {
		// TODO Auto-generated method stub
		return dao.selectByid(id);
	}

	public void insert(User u) {
		// TODO Auto-generated method stub
	
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	public List<User> queryAll(String where, String limit) {
		// TODO Auto-generated method stub
		return null;
	}



	
  
}
