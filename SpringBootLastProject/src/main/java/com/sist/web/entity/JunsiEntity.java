package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/*
 * GENO int 
POSTER text 
TITLE text 
TITLE2 text 
KIND text 
PERIOD text 
LOC text 
LOC2 text 
AREA text 
AREA2 text 
ITEM text 
HOST text 
URL text 
PRICE text 
TIME text 
HASHTAG text 
CONTENT text 
HIT int 
LIKE_COUNT int 
GOOD text
 */
@Entity
@Table(name="god_exhibition")
@Getter
@Setter
public class JunsiEntity {
	@Id
	private int geno;
	private String poster,title,title2,kind,period,loc,loc2,area,area2,item,host,url,price,time,hashtag,content,good;
	private int hit,like_count;
}
