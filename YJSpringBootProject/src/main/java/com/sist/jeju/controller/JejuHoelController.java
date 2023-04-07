package com.sist.jeju.controller;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.jeju.dao.JejuHotelDAO;
import com.sist.jeju.entity.*;

@Controller
@RequestMapping("hotel/")
public class JejuHoelController {
	@Autowired
	private JejuHotelDAO dao;

	@GetMapping("hotel_list")
	public String hotel_list(String page, Model model) {
		if (page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 8;
		int start = (curpage * rowSize) - rowSize;
		List<jejuHotelEntity> list = dao.jejuListData(start);

		int totalpage = dao.jejuTotalPage();
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "hotel/hotel_list");
		return "main";
	}

	@GetMapping("hotel_popular")
	public String hotel_popular(Model model) {
		List<jejuHotelEntity> list = dao.jejucategoryListData();

		model.addAttribute("list", list);
		model.addAttribute("main_html", "hotel/hotel_popular");
		return "main";
	}


	@GetMapping("hotel_detail")
	public String hotel_detail(int hno,Model model)
	{
		jejuHotelEntity vo=dao.findByHno(hno);
		
		String hotel_image= vo.getHotel_image();
		List<String>iList=new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(hotel_image,"^");
	    while(st.hasMoreTokens()) 
	    {
	    	  iList.add(st.nextToken());
	    }
	    
		/*
		 * if(vo.getGrade()=="") { vo.setGrade("미등록"); }
		 */
	    model.addAttribute("iList",iList); // 호텔이미지 리스트
		model.addAttribute("vo",vo);
		model.addAttribute("main_html", "hotel/hotel_detail");
	    return "main";
	}
	
}
