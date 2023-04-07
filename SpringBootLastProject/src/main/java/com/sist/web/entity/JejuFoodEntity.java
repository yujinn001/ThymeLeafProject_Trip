package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jeju_food")
@Getter
@Setter
public class JejuFoodEntity {
	@Id
	private int no;
	private String title,url,poster,image,addr,addr2,tel,type,parking,time,menu,score;
	private int hit;
}
