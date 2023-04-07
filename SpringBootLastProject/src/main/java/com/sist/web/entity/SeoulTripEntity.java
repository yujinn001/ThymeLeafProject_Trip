package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 * TNO int 
TCNO int 
NAME text 
IMAGE text 
CONTENT text 
ADDR text 
HIT int 
JJIM int 
TLIKE int
 */
@Entity
@Table(name="gg_trip")
@Getter
@Setter
public class SeoulTripEntity {
	@Id
	private int tno;
	private int tcno,hit,jjim,tlike;
	private String name,image,content,addr;
	
}
