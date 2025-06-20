package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	WelcomeController(){
	//	System.out.println("WelcomeController 객체 생성 완료");
	}

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String welcome(Model model) {
		System.out.println("WelcomeController의 welcome 함수 입장 완료");
		model.addAttribute("greeting", "Welcome to BookMarket");
		model.addAttribute("strapline", "Welcome to WebShopping Mall!");
		
		return "welcome";
	}

}
