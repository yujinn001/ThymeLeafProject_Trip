package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.RecipeEntity;

@Repository
public interface RecipDAO extends JpaRepository<RecipeEntity,Integer>{
	@Query(value="select * from recipe "
			   + "order by no asc limit :start,20",nativeQuery=true)
	public List<RecipeEntity>  RecipeListData(@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/20.0) from recipe",nativeQuery=true)
	public int RecipeTotalPage();
}