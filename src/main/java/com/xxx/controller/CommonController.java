package com.xxx.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Stu;
import com.xxx.po.Teacher;
import com.xxx.service.IStuService;
import com.xxx.service.ITeacherService;

@Controller
public class CommonController {
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IStuService stuService;

	@RequestMapping("/login.do")
	public String login(String no, String pwd, String role, HttpServletResponse response) {
		if ("teacher".equals(role)) {// 老师登陆
			Teacher teacher = this.teacherService.login(no, pwd);
			if (teacher != null) {//成功
				String teacherJson = null;
				try {
					//转码
					teacherJson = URLEncoder.encode(teacher.toString(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Cookie cookie = new Cookie("teacher", teacherJson);
				cookie.setMaxAge(60 * 60 * 24); // 时秒为单位
				response.addCookie(cookie);
				return "/WEB-INF/teacher.html";
			} else {// 失败
				return "/login.html";
			}
		} else if ("student".equals(role)) {// 学生登陆
			return "/login.html";
		} else {// 有问题
			return "/login.html";
		}
	}
	@ResponseBody
	@RequestMapping(value="/ajaxLogin.do",method=RequestMethod.POST)
	public Object ajaxLogin(String no, String pwd, String role) {
		if ("teacher".equals(role)) {
			Teacher teacher = this.teacherService.login(no, pwd);
			return teacher;
		} else if ("student".equals(role)) {
			Stu stu = this.stuService.StuLogin(no, pwd);
			System.out.println(no+":"+pwd);
			System.out.println(stu);
			return stu;
		}
		return null;
	}
}
