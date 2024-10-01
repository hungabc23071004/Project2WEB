package com.nguyenhung.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenhung.Model.BuildingDTO;
import com.nguyenhung.builder.BuildingSearchBuilder;
import com.nguyenhung.converter.BuildingDTOConverter;
import com.nguyenhung.converter.BuildingSearchBuilderConverter;
import com.nguyenhung.repository.BuildingRespository;
import com.nguyenhung.repository.entity.BuildingEntity;
import com.nguyenhung.service.BuildingService;


@Service
public class BuildingServiceImpl implements BuildingService{
     @Autowired
	private BuildingRespository buildingRepository;
    @Autowired 
    private BuildingDTOConverter buildingDTOConnverter;
    @Autowired
    private  BuildingSearchBuilderConverter buildingSearchBuilderConverter ;
   
	 @Override
	public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		 BuildingSearchBuilder buildingSearchBuilder=buildingSearchBuilderConverter.toBuildingSearchBuilder( params,  typeCode);
		List<BuildingEntity> buildingEntities= buildingRepository.findAll(buildingSearchBuilder);
		List<BuildingDTO> result=new ArrayList<BuildingDTO>();
		for(BuildingEntity item: buildingEntities) {
			BuildingDTO building=buildingDTOConnverter.toBuildingDTO(item);
		    result.add(building);
		}
		return result;
	}
  
}
