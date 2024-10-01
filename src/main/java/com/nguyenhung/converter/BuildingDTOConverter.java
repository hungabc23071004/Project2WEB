package com.nguyenhung.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nguyenhung.Model.BuildingDTO;
import com.nguyenhung.repository.entity.BuildingEntity;
import com.nguyenhung.repository.entity.RentAreaEntity;


@Component
public class BuildingDTOConverter {
	
     @Autowired
     private ModelMapper modelMapper;
     public BuildingDTO toBuildingDTO(BuildingEntity item) {
    	    BuildingDTO building=modelMapper.map(item, BuildingDTO.class);
    	    List<RentAreaEntity> rentAreaEntity= item.getItems();
		    String areaResult=rentAreaEntity.stream().map(it->it.getValue().toString()).collect(Collectors.joining(","));
		    building.setRentArea(areaResult);
	        building.setAdress(item.getStreet()+", "+item.getWard()+", "+item.getDistrict().getName());
		    return building;
     }
}
