package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jeju_location")
@Getter
@Setter
public class JejuLocationEntity {
	@Id
	private int no;
	private int hit,price2;
	private String title,url,poster,content,price,image,info,addr,type;
	
}
