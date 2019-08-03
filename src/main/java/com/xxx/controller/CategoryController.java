package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Category;
import com.xxx.service.ICategoryService;

@Controller //注入IOC
public class CategoryController {
	@Autowired
	private ICategoryService service;
	
	@ResponseBody//ajax请求时响应  记住两次未写了
	@RequestMapping("/getAllcategory.do")
	public List<Category> getAllcategory() {
		List<Category> list=this.service.getAllcategory();
		for (Category category : list) {
			System.out.println(category);
		}
		return list;
	}
}
