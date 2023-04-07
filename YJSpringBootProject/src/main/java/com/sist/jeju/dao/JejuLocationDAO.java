package com.sist.jeju.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.jeju.entity.jejuLocationEntity;

@Repository
public interface JejuLocationDAO extends JpaRepository<jejuLocationEntity,Integer>{
	@Query(value="select * "
		       + "from jeju_location "
		       + "where hit >0 order by hit desc",nativeQuery = true)
	public List<jejuLocationEntity> jejuLocationHitListData();
	
	// 디테일 
	@Query(value="select * from jeju_location "
			   + "where addr LIKE concat('%',:addr,'%') order by no limit :start,10",nativeQuery = true) //limit 페이징 
	public List<jejuLocationEntity> locationFindData(@Param("addr") String addr,@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from jeju_location "
			    +"where addr LIKE concat('%',:addr,'%')",nativeQuery = true)
	public int locationfindTotalPage(String addr);
	
	// 디테일 내용
	public jejuLocationEntity findByNo(@Param("no") Integer no);
}
