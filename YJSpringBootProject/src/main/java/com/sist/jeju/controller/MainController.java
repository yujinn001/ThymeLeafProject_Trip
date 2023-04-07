package com.sist.jeju.controller;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jeju.entity.*;
import com.sist.jeju.dao.*;

@Controller
public class MainController {
	@Autowired
	private JejuHotelDAO dao;
	
	@Autowired
	private JejuLocationDAO ldao;
	
	@GetMapping("/")
	public String jeju_main(Model model,HttpServletRequest requset)
	{
		// 제주 인기 호텔
		List<jejuHotelEntity> sList=dao.jejuStarListData();
		
		// 제주 인기 명소
		List<jejuLocationEntity> lList=ldao.jejuLocationHitListData();
		
		// 쿠키내용추가
		 List<jejuHotelEntity> clist = new ArrayList<jejuHotelEntity>();
			Cookie[] cookies = requset.getCookies();
			if (cookies != null) {
				for (int i = cookies.length - 1; i >= 0; i--) {
					if (cookies[i].getName().startsWith("jeju")) {
						String hno = cookies[i].getValue();
						jejuHotelEntity vo = dao.findByHno(Integer.parseInt(hno));
						clist.add(vo);
					}
				}
			}
			  model.addAttribute("clist",clist);
		model.addAttribute("sList",sList);
		model.addAttribute("lList",lList);
		model.addAttribute("main_html","main/home");
		return "main";
	}
	
	
	
	
	
	@GetMapping("/jeju/main") // 제주 확인용
	public String jeju_list(Model model)
	{
		List<jejuHotelEntity> list=dao.jejucategoryListData();
		
		
		for(jejuHotelEntity vo:list )
		{
			String name=vo.getName();
			if(name.length()>7) {
				name=name.substring(0,7)+"...";
				vo.setName(name);
			}
			vo.setName(name);
		}
		model.addAttribute("list",list);
		return "jeju/jeju_main";
	}
	
	
	/// 쿠키 관련된 내용

	 @GetMapping("hotel/hotel_detail_before")
	public String hotel_detail_before(int hno,HttpServletResponse response)
	{
			Cookie cookie=new Cookie("jeju"+hno,String.valueOf(hno));
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			return "redirect:../hotel/hotel_detail?hno="+hno;
	}

	 
	 
	 
	 
}
