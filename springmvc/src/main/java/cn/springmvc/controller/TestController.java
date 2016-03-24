package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Controller
@RequestMapping(value="/user")
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/insertUser")
	public ModelAndView insertUser(HttpServletRequest request,User user){
		System.out.println(user.getName());
		ModelAndView mv = new ModelAndView("index");
		String name = request.getParameter("user.name");
		String pass = request.getParameter("user.password");
		user.setName(name);
		user.setPassword(pass);
		int result = userService.insertUser(user);
		return mv;
	}
	@RequestMapping(value="/goAddUser")
	public ModelAndView goInsertUser(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
