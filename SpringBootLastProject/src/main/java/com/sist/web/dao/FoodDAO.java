package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.JejuFoodEntity;

@Repository
public interface FoodDAO extends JpaRepository<FoodEntity,Integer>{
	@Query(value="select * from project_food "
			 + "limit 0,3",nativeQuery=true)
		public List<FoodEntity> FoodTop3Data();
	
	@Query(value="select * from project_food "
			 + "limit 0,6",nativeQuery=true)
		public List<FoodEntity> FoodTop6Data();
	
	@Query(value="select * from project_food "
			   + "order by fno asc limit :start,20",nativeQuery=true)
	public List<FoodEntity> FoodListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from project_food",nativeQuery=true)
	public int FoodTotalPage();
	
	public FoodEntity findByFno(@Param("fno") Integer fno);
}
