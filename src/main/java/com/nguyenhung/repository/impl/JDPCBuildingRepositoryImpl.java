package com.nguyenhung.repository.impl;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.nguyenhung.builder.BuildingSearchBuilder;
import com.nguyenhung.repository.BuildingRespository;
import com.nguyenhung.repository.entity.BuildingEntity;
import com.nguyenhung.utils.ConnectionJDBCUtil;
import com.nguyenhung.utils.NumberUtil;
import com.nguyenhung.utils.StringUtil;
@Repository
@Primary
public class JDPCBuildingRepositoryImpl implements BuildingRespository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Long staffId=buildingSearchBuilder.getSatffId();
		if(staffId !=null) {
			sql.append("inner join assignmentbuilding  on  assignmentbuilding.buildingid=b.id ");
		}
		List<String> typeCode=buildingSearchBuilder.getTypecode();
		if(typeCode!=null && typeCode.size() !=0) {
			sql.append("inner join buildingrenttype on buildingrenttype.buildingid=b.id ");
			sql.append("inner join renttype on renttype.id = buildingrenttype.renttypeid " );
		}
	}
	public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {

			try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item :fields) {
				item.setAccessible(true);
				String fieldName=item.getName();
				if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.contains("area") && !fieldName.contains("rentPrice")) {
					Object value= item.get(buildingSearchBuilder);
					if(value!=null) {
						if(item.getType().getName().equals("java.lang.Long") ||item.getType().getName().equals("java.lang.Integer") )
				  where.append(" AND b."+fieldName+ " = " +value);
			
					else if(item.getType().getName().equals("java.lang.String")) {
						where.append(" AND b."+fieldName+" like '%"+value+"%' ");
					}
				}
				}
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
    public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
    	Long staffId=buildingSearchBuilder.getSatffId();
		if(staffId!=null) {
			where.append(" AND assignmentbuilding.staffid = "+staffId);
		}
	    Long rentAreaTo=buildingSearchBuilder.getAreaTo();
	    Long rentAreaFrom=buildingSearchBuilder.getAreaFrom();
		
		if( rentAreaTo !=null || rentAreaFrom!=null) {
	    where.append(" AND exists (select * from rentarea  where b.id = rentarea.buildingid ");
		
		if( rentAreaTo !=null) {
			where.append(" AND rentarea.value <= "+rentAreaTo );
		}
		if(rentAreaFrom!=null) {
			where.append(" AND rentarea.value>= "+rentAreaFrom);
		}
		where.append(" ) ");
		}
		
		Long rentPriceTo=buildingSearchBuilder.getRentPriceTo();
		Long rentPriceFrom=buildingSearchBuilder.getRentPriceFrom();;
		
		if(rentPriceTo!=null) {
			where.append(" AND b.rentprice <= "+rentPriceTo);
		}
		if(rentPriceFrom!=null) {
			where.append(" AND b.rentprice >= "+rentPriceFrom);
		}
		List<String> typeCode=buildingSearchBuilder.getTypecode();
		if(typeCode !=null && !typeCode.equals("")) {
			where.append(" AND renttype.code in ('" +String.join("','", typeCode)+"')" );
		}
	}
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql=new StringBuilder("SELECT b.id, b.name, b.ward, b.districtid, b.street, b.floorarea, b.rentprice, b.servicefee, b.brokeragefee, b.managername, b.managerphonenumber,b.numberofbasement from building b ");
		joinTable(buildingSearchBuilder,sql);
		StringBuilder where=new StringBuilder(" where 1=1");
		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder ,where);
		where.append(" group by b.id");
		sql.append(where);
		Query query=entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}

}
