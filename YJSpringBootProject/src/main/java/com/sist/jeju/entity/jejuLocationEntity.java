package com.sist.jeju.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/*
 * TITLE text 
URL text 
POSTER text 
CONTENT text 
PRICE text 
PRICE2 int 
IMAGE text 
INFO text 
NO int 
ADDR text 
TYPE text 
HIT int
 */
@Getter
@Setter
@Entity(name="jeju_location")
public class jejuLocationEntity {
	@Id
	private int no;
	private String title,url,poster,content,price,image,info,addr,type;
	private int price2,hit;
}
