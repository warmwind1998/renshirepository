package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DepartmentDao;
import dao.UserDao;
import entity.Department;
import entity.User;
import service.UserService;

@Controller
@RequestMapping("User")
public class User_Controller extends BasicController<User>{
	
	
	@Autowired
	UserService service;
//	@Autowired
//	UserDao dao;
	@Autowired
	DepartmentDao ddao;
	User current;
	@RequestMapping("index")
	public String index(HttpServletRequest req,HttpServletResponse resp){
		
		super.index(req, resp);
		req.setAttribute("sexs", User.sexs);
		return "User/index";
	}
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse resp){
		req.setAttribute("sexs",User.sexs);
		req.setAttribute("deplist", ddao.selectAll());
		return "User/edit";
	}
//	@RequestMapping("edit")
//	public String edit(int id,HttpServletRequest req,HttpServletResponse resp){
//		req.setAttribute("info",service.selectByid(id));
//		
//		return add(req,resp);
	}
//	@RequestMapping("save")
//	public String save(User u,HttpServletRequest req,HttpServletResponse resp){
//		
//		dao.insert(u);
//		return index(current,page,req,resp);
//	}
//	@RequestMapping("update")
//	public String update(User u,HttpServletRequest req,HttpServletResponse resp){
//		dao.update(u);
//		return index(current,page,req,resp);
//	}
//	@RequestMapping("delete")
//	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
//		dao.delete(id);
//		return index(current,page,req,resp);
//	}

