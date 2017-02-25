package com.jun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jun.service.Jkjc001Service;

@Controller
@RequestMapping("/query")
public class Jkjc001Controller {
	
	@Autowired
	public Jkjc001Service Jkjc001Controller;
	
	@ResponseBody
	@RequestMapping(value="/pubdoc", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String getIndex(String input, String mode){
		return Jkjc001Controller.getPubdoc(input, mode);
	}
	
}
