package com.sist.web.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.JejuFoodEntity;
import com.sist.web.entity.JejuPageVO;



@RestController
@CrossOrigin("http://localhost:3000") // 포트가 달라 3000번 포트를 허용한다
public class FoodController {
	@Autowired
	private FoodDAO fDao;
	
	@GetMapping("food/food_top3")
	public List<FoodEntity> food_top3() 
	{
		List<FoodEntity> list=fDao.FoodTop3Data();
		for(FoodEntity vo:list)
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
	@GetMapping("food/food_top6")
	public List<FoodEntity> food_top6() 
	{
		List<FoodEntity> list=fDao.FoodTop6Data();
		for(FoodEntity vo:list)
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
	
	@GetMapping("food/food_list_react")
	public List<FoodEntity> foodList(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start =(rowSize*curpage)-rowSize;
		
		List<FoodEntity> list=fDao.FoodListData(start);
		
		return list;
	}
	
	@GetMapping("food/food_page_react")
	public JejuPageVO FoodPageData(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		int totalpage =fDao.FoodTotalPage();
		
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
	
	@GetMapping("food/food_detail_react")
	public FoodEntity food_detail(int fno)
	{
		FoodEntity vo=fDao.findByFno(fno);
		
		return vo;
	}
}
