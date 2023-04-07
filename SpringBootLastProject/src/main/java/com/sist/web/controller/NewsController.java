package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.news.*;
import com.sist.web.entity.*;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class NewsController {
	@Autowired
	private NewsManager mgr;
	
	@GetMapping("news/news_list_react")
	public List<NewsVO> news_list(String title)
	{
		List<NewsVO> list=mgr.newsListData(title);
		
		return list;
	}
	
	@GetMapping("news/news_aop_react")
	public List<NewsVO> news_aop()
	{
		List<NewsVO> list=mgr.newsListData("서울"); // 검색될 내용
		List<NewsVO> nList=new ArrayList<NewsVO>();
		for(int i=0;i<7;i++)
		{
			NewsVO vo=list.get(i);
			nList.add(vo);
			
		}
		
		return nList;
		
	}
	@GetMapping("news/news_Top5_react")
	public List<NewsVO> news_Top5()
	{
		List<NewsVO> list=mgr.newsListData("서울"); // 검색될 내용
		List<NewsVO> nList=new ArrayList<NewsVO>();
		for(int i=0;i<7;i++)
		{
			NewsVO vo=list.get(i);
			nList.add(vo);
		}
		
		return nList;
		
	}
}
