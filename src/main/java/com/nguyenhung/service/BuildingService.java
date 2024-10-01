package com.nguyenhung.service;

import java.util.List;
import java.util.Map;

import com.nguyenhung.Model.BuildingDTO;



public interface BuildingService {
	

	List<BuildingDTO> findAll(Map<String, Object> params, List<String> typecode);
}
