package com.sist.jeju.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.jeju.dao.JejuLocationDAO;
import com.sist.jeju.entity.jejuLocationEntity;

@Controller
@RequestMapping("location/")
public class JeJuLocationController {
	@Autowired
	private JejuLocationDAO dao;

	@RequestMapping("location_find")
	public String location_list(String addr, String page, Model model) {
		if (addr == null)
			addr = "제주시";

		if (page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (curpage * rowSize) - rowSize;
		List<jejuLocationEntity> list = dao.locationFindData(addr, start);
		for (jejuLocationEntity vo : list) {
			addr = vo.getAddr();
			String[] addr1 = addr.split(" ");

			vo.setAddr(addr1[1]);
		}

		int totalpage = dao.locationfindTotalPage(addr);
		final int Block = 10;
		int startPage = ((curpage - 1) / Block * Block) + 1;
		int endPage = ((curpage - 1) / Block * Block) + Block;
		if (endPage > totalpage)
			endPage = totalpage;
		System.out.println("startpage"+startPage);
		System.out.println("endPage"+endPage);
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("addr", addr);
		model.addAttribute("main_html", "location/location_find");
		return "main";
	}

	@GetMapping("location_detail")
	public String location_detail(int no, Model model) {
		jejuLocationEntity vo = dao.findByNo(no);
		
		model.addAttribute("vo", vo);

		model.addAttribute("main_html", "location/location_detail");
		return "main";
	}
}
