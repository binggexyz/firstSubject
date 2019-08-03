package com.xxx.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	@RequestMapping("/subject.do")
	public String subject(HttpServletRequest req) {
		boolean flag = false;//是否登陆过
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {//如果cookie为null
			return "/login.html";
		}else {//如果cookie不为null,
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if("teacher".equals(name)) {
					flag = true;
					break;
				}
			}
			if(flag) {//登陆过
				return "/WEB-INF/subject.html";
			}else {//没有登陆过
				return "/login.html";
			}
		}
	}
	@RequestMapping("/clazz.do")
	public String clazz(HttpServletRequest req) {
		boolean flag = false;//是否登陆过
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {//如果cookie为null
			return "/login.html";
		}else {//如果cookie不为null,
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if("teacher".equals(name)) {
					flag = true;
					break;
				}
			}
			if(flag) {//登陆过
				return "/WEB-INF/clazz.html";
			}else {//没有登陆过
				return "/login.html";
			}
		}
	}
	
	@RequestMapping("/toTeacherPage.do")
	public String toTeacherPage() {
		return "/WEB-INF/teacher.html";
	}
}
