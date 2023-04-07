package com.sist.web.controller;

import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("http://localhost:3000")
public class JejuCookieController {
	@GetMapping("jeju/food_detail_before")
	public String food_detail_before(int no,HttpServletResponse response)
	{
		Cookie cookie=new Cookie("jeju"+no,String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return "redirect:../jeju/food_detail_react?no="+no;
	}
	
	@GetMapping("seoul/food_detail_before")
	public String seoul_food_detail_before(int no,HttpServletResponse response)
	{
		Cookie cookie=new Cookie("jeju"+no,String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return "redirect:../jeju/food_detail_react?no="+no;
	}
}
