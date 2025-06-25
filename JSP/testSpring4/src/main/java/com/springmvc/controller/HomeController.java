package com.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.UserDto;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String main() {
		return "home";
	}
	
	@PostMapping(value="/case1", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String case1(@RequestBody HashMap<String, Object> map) {
		System.out.println("mapping ok");
		String name = (String)map.get("name");
		String age = (String)map.get("age");
		
		System.out.println(name + age);
		System.out.println(map);
		
		return "success";
		
	}
	
	@PostMapping("/case2")
	@ResponseBody
	public UserDto case2(@RequestBody HashMap<String, Object> map) {
		System.out.println("case2");
		String id = (String)map.get("id");
		UserDto dto = new UserDto();
		dto.setId(id);
		System.out.println(dto);
		
		return dto;
	}
	
	@ResponseBody
	@PostMapping("/case3")
	public List<UserDto> case3(@RequestBody HashMap<String, Object> map){
		System.out.println("case3");
		//String id = (String) map.get("id");
		
		UserDto dto1 = new UserDto();
		dto1.setId("no.1");
		dto1.setName("kim");
		UserDto dto2 = new UserDto();
		dto2.setId("no.2");
		dto2.setName("lee");
		UserDto dto3 = new UserDto();
		dto3.setId("no.3");
		dto3.setName("choi");
		
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		return list;
	}
}
