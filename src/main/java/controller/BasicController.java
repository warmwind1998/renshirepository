package controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BasicDao;
import service.BasicService;
import utils.SearchInfo;

public class BasicController<T> {
	
	private BasicService<T> getService(){
		try{
		Field f=this.getClass().getDeclaredField("service");
		return (BasicService<T>)f.get(this);
		}catch(Exception e)
		{
			return null;
		}
	}
	
	
	private String getTname(){
		        //通过反射机制获取泛型的类类型
		      Class  entityClass = (Class<T>) ((ParameterizedType) 
		    		  this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		   return entityClass.getSimpleName();
	}
	
	@RequestMapping("index")
	public String index(HttpServletRequest req,HttpServletResponse resp){
		SearchInfo info=SearchInfo.create(req,true); 
		req.setAttribute("list",getService().selectAll(info));
		 return getTname()+"/index";   //值域
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse resp){
		 return getTname()+"/edit";  
	}
	@RequestMapping("edit")
	public String edit(int id,HttpServletRequest req,HttpServletResponse resp){
		req.setAttribute("info", getService().selectById(id));
		 return add(req, resp);  
	}
	
	@RequestMapping("save")
	public String save(T u,HttpServletRequest req,HttpServletResponse resp){
		getService().insert(u);
		return index(req, resp);
	}
	
	@RequestMapping("update")
	public String update(T u,HttpServletRequest req,HttpServletResponse resp){
		getService().update(u);
		return index(req, resp);
	}
	
	
	@RequestMapping("delete")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		getService().delete(id);
		return index(req, resp);
	}
}
