package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.JusiDAO;
import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.JejuPageVO;
import com.sist.web.entity.JunsiEntity;
import com.sist.web.entity.JunsiFindVO;
import com.sist.web.entity.SeoulLocationEntity;

@RestController
@CrossOrigin("http://localhost:3000") // 포트가 달라 3000번 포트를 허용한다
public class JusiController {
	@Autowired
	private JusiDAO dao;
	
	@GetMapping("seoul/jusi_find_react")
	   public List<JunsiFindVO> junsi_find(String page, String title){
	      List<JunsiFindVO> list = new ArrayList<JunsiFindVO>();
	      if(page == null)
	         page = "1";
	      int curpage = Integer.parseInt(page);
	      int start = (curpage*12)-12;
	      List<JunsiEntity> jList = dao.JunsiFindData(title, start);
	      int totalpage = dao.junsiFindTotalPage(title);
	      int i = 0;
	      for(JunsiEntity jvo:jList) {
	    	  JunsiFindVO vo = new JunsiFindVO();
	         vo.setGeno(jvo.getGeno());
	         vo.setPoster(jvo.getPoster());
	         vo.setTitle(jvo.getTitle());
	         if(i==0) {
	            vo.setCurpage(curpage);
	            vo.setTotalpage(totalpage);
	         }
	         list.add(vo);
	         i++;
	      }
	      
	      return list;
	   }
	@GetMapping("seoul/jusi_find_page_react")
	public JejuPageVO seoul_LocationPageData(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		int totalpage =dao.junsiFindTotalPage(page);
				
		
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
	
	@GetMapping("seoul/junsi_detail_react")
	public JunsiEntity seoul_location_detail(int geno)
	{
		JunsiEntity vo=dao.findByGeno(geno);
		
		return vo;
	}
	
	//top3
	@GetMapping("junsi/junsi_top3")
	public List<JunsiEntity> junsi_top3() 
	{
		List<JunsiEntity> list=dao.junsiTop3Data();
		for(JunsiEntity vo:list)
		{
			String loc=vo.getLoc();
			
			if(loc.length()>25)
			{
				loc=loc.substring(0,25);
				vo.setLoc(loc+"...");
			}
		}
		return list;
	}
}
