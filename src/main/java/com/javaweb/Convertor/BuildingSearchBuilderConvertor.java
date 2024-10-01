package com.javaweb.Convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConvertor {
	public static BuildingSearchBuilder toBuildingSearchBuilder(HashMap<String,Object> building,List<String> type) {
		BuildingSearchBuilder buidingSearchBuilder = new BuildingSearchBuilder.Builder()
																	.setName(MapUtil.getObject(building, "name", String.class))
																	.setFloorarea(MapUtil.getObject(building, "floorarea", Long.class)) 
																	.setWard(MapUtil.getObject(building, "ward", String.class))
																	.setStreet (MapUtil.getObject(building, "street", String.class))
																	.setDistrictid (MapUtil.getObject(building, "districtId", String.class)) 
																	.setNumberofbasement (MapUtil.getObject (building, "numberofBasement", Integer.class)) 
																	.setTypecode(type)
																	.setManagername (MapUtil.getObject(building, "managerName", String.class))
																	.setManagerphonenumber(MapUtil.getObject(building, "managerphoneNumber", String.class)) 
																	.setPriceTo(MapUtil.getObject(building, "rentPriceTo", Long.class))
																	.setPriceFrom(MapUtil.getObject(building, "rentPriceFrom", Long.class))
																	.setAreaFrom(MapUtil.getObject(building, "areaFrom", Long.class))
																	.setAreaTo(MapUtil.getObject(building, "areaTo", Long.class))
																	.setStaffid(MapUtil.getObject(building, "staffId", Long.class))
																	.build();
		return buidingSearchBuilder;
	}
}
