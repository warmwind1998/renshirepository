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

@Controller
@RequestMapping("Department")
public class Department_Controlller {
	
	@Autowired
	DepartmentDao ddao;
	
	@RequestMapping("index")
	public String index(HttpServletRequest req,HttpServletResponse resp){
		req.setAttribute("list", ddao.selectAll());
		
		return "Department/index";
	}
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse resp){
		req.setAttribute("deplist", ddao.selectAll());
		return "Department/edit";
	}
	@RequestMapping("edit")
	public String edit(int id,HttpServletRequest req,HttpServletResponse resp){
		req.setAttribute("info",ddao.selectByid(id));
		
		return add(req,resp);
	}
	@RequestMapping("save")
	public String save(Department d,HttpServletRequest req,HttpServletResponse resp){
		
		ddao.insert(d);
		return index(req,resp);
	}
	@RequestMapping("update")
	public String update(Department d,HttpServletRequest req,HttpServletResponse resp){
		ddao.update(d);
		return index(req,resp);
	}
	@RequestMapping("delete")
	public String delete(int id,HttpServletRequest req,HttpServletResponse resp){
		ddao.delete(id);
		return index(req,resp);
	}
}
