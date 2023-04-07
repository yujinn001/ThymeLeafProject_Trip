package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;

@Repository
public interface JusiDAO extends JpaRepository<JunsiEntity,Integer>{
	  // 검색
	   @Query(value="select * from god_exhibition "
	         + "where title like concat('%', :title, '%') "
	         + "limit :start, 12", nativeQuery = true)
	   public List<JunsiEntity> JunsiFindData(@Param("title") String title,@Param("start") Integer start);
	   
	   @Query(value="select ceil(count(*)/12.0) from god_exhibition "
	         + "where title like concat('%', :title, '%') ", nativeQuery = true)
	   public int junsiFindTotalPage(@Param("title") String title);
	   
	   public JunsiEntity findByGeno(@Param("geno") Integer geno);
	   
	   @Query(value="select * from god_exhibition where title like concat('%', '서울', '%') "
				 + "limit 0,3",nativeQuery=true)
			public List<JunsiEntity> junsiTop3Data();
}
