package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import java.util.*;
@RestController
@CrossOrigin("http://localhost:3000") // 포트가 달라 3000번 포트를 허용한다
public class SeoulController {
	@Autowired
	private SeoulLocationDAO lDao;
	
	@GetMapping("seoul/location_list_react")
	public List<SeoulLocationEntity> seoul_location_list(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start =(rowSize*curpage)-rowSize;
		
		List<SeoulLocationEntity> list=lDao.seoulLocationListData(start);
		
		return list;
	}
	@GetMapping("seoul/location_page_react")
	public JejuPageVO seoul_LocationPageData(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		int totalpage =lDao.seoulLocationTotalPage();
				
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		JejuPageVO vo=new JejuPageVO();
		vo.setCurpage(curpage);
		vo.setEndPage(endPage);
		vo.setStartPage(startPage);
		vo.setTotalpage(totalpage);
		
		return vo;
	}
	
	@GetMapping("seoul/location_detail_react")
	public SeoulLocationEntity seoul_location_detail(int no)
	{
		SeoulLocationEntity vo=lDao.findByNo(no);
		
		return vo;
	}
	
	@GetMapping("seoul/location_top3")
	public List<SeoulLocationEntity> food_top3() 
	{
		List<SeoulLocationEntity> list=lDao.locationTop3Data();
		for(SeoulLocationEntity vo:list)
		{
			String addr=vo.getAddress();
			
			if(addr.length()>25)
			{
				addr=addr.substring(0,25);
				vo.setAddress(addr+"...");
			}
		}
		return list;
	}
}