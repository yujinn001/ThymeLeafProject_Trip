package com.sist.web.dao;

import org.springframework.stereotype.Repository;

import com.sist.web.entity.JejuLocationEntity;
import com.sist.web.entity.SeoulLocationEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface SeoulLocationDAO extends JpaRepository<SeoulLocationEntity,Integer>{
	@Query(value="select * from seoul_location "
			   + "order by no asc limit :start,20",nativeQuery=true)
	public List<SeoulLocationEntity> seoulLocationListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from seoul_location",nativeQuery=true)
	public int seoulLocationTotalPage();
	
	public SeoulLocationEntity findByNo(@Param("no") Integer no);
	
	@Query(value="select * from seoul_location "
			 + "limit 0,3",nativeQuery=true)
		public List<SeoulLocationEntity> locationTop3Data();
}
