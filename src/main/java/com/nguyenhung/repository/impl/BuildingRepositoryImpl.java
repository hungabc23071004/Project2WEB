package com.nguyenhung.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.nguyenhung.builder.BuildingSearchBuilder;
import com.nguyenhung.repository.BuildingRespository;
import com.nguyenhung.repository.entity.BuildingEntity;
@Repository

public class BuildingRepositoryImpl implements BuildingRespository  {
    
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		// TODO Auto-generated method stub
//		JDQL : JPA Query L
//		String sql="FROM BuidlingEntity b where b.id = 1";
//		Query query=entityManager.createQuery(sql,BuidlingEntity.class);
		
//		SQL Native
		String sql="SELECT * FROM building b where b.name like '%building%' ";
		Query query=entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
		
		
	}

}
