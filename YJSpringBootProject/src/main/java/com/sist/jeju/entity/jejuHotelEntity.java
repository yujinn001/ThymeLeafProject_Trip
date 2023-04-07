package com.sist.jeju.entity;
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

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="JJ_HOTEL") // 3차 테이블명 JJ_HOTEL
public class jejuHotelEntity {
	@Id
	private int hno;
	
	private String grade,name,addr,intro,time,hotel_image;
	private int all_cate_no,h_crawl_no,account,like_count,jjim_count;
	private double star;
	
}
