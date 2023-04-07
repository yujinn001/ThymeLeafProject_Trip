package com.sist.jeju.dao;

import java.util.*;
import com.sist.jeju.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/*
HNO         NOT NULL NUMBER        
ALL_CATE_NO          NUMBER        
H_CRAWL_NO           NUMBER        
GRADE                VARCHAR2(20)  
NAME        NOT NULL VARCHAR2(200) 
ADDR        NOT NULL VARCHAR2(200) 
INTRO                CLOB          
TIME        NOT NULL VARCHAR2(100) 
STAR                 NUMBER(2,1)   
ACCOUNT              NUMBER        
HOTEL_IMAGE NOT NULL VARCHAR2(260) 
LIKE_COUNT           NUMBER        
JJIM_COUNT           NUMBER 
 */
@Repository
public interface JejuHotelDAO extends JpaRepository<jejuHotelEntity,Integer>{
	// 메인페이지 별점으로 출력
	@Query(value="select * "
		       + "from JJ_HOTEL "
		       + " where star>=4.9 order by star desc",nativeQuery = true)
	public List<jejuHotelEntity> jejuStarListData();
	
	
	// 5성급, 4성급, 3성급 출력
	//public jejuEntity findByHno(@Param("hno") Integer hno);
	@Query(value="select * "
		       + "from JJ_HOTEL "
		       + "where grade IN ('5성급','4성급','3성급') order by star",nativeQuery = true)
	public List<jejuHotelEntity> jejucategoryListData();
	
	// 카테고리 링크값
	@Query(value="select * "
		       + "from JJ_HOTEL "
		       + "order by hno desc limit :start,8",nativeQuery = true)
	public List<jejuHotelEntity> jejuListData(@Param("start") Integer start);
	// 리스트 페이징
	@Query(value="select ceil(count(*)/10.0) from JJ_HOTEL",nativeQuery=true )
	public int jejuTotalPage();
	
	// 디테일 
	jejuHotelEntity findByHno(@Param("hno") Integer hno);
}
