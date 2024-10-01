package com.nguyenhung.api;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenhung.Model.BuildingDTO;
import com.nguyenhung.Model.BuildingRequestDTO;
import com.nguyenhung.repository.entity.BuildingEntity;
import com.nguyenhung.repository.entity.DistrictEntity;
import com.nguyenhung.service.BuildingService;


@RestController
@PropertySource("classpath:application.properties")
@Transactional
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@Value("${dev.nguyen}")
	private String data;
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping(value="api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
										 @RequestParam(name="typeCode", required=false) List<String> typecode){
		List<BuildingDTO> result=buildingService.findAll(params, typecode);
		return   result;
	}
	
	
	
	
//  @GetMapping(value="api/building/")
//  public Object getBuilding(@RequestBody BuildingDTO building) {
//	  
//     valiDate(building);
//	 return null;
//  }
  
  
  @DeleteMapping(value="api/building/{id}")
  public void deleteBuilding(@PathVariable Long id) {
	 BuildingEntity buildingEntity=entityManager.find(BuildingEntity.class, id);
	 entityManager.remove(buildingEntity);
	 System.out.print(data);
  }
  
  @PostMapping(value="/api/building")
  public void createBuilding(@RequestBody BuildingRequestDTO  building) {
	  BuildingEntity buildingEntity=new BuildingEntity();
	  buildingEntity.setName(building.getName());
	  buildingEntity.setStreet(building.getStreet());
	  buildingEntity.setWard(building.getWard());
	  DistrictEntity districtEntity= new DistrictEntity();
	  districtEntity.setId(building.getDistrictId());
	  buildingEntity.setDistrict(districtEntity);
	  entityManager.persist(buildingEntity);
	  System.out.println("ok");
}
   @PutMapping(value="/api/building")
   public void updateBuilding(@RequestBody BuildingRequestDTO  building) {
		  BuildingEntity buildingEntity=new BuildingEntity();
		  buildingEntity.setId(3L);
		  buildingEntity.setName(building.getName());
		  buildingEntity.setStreet(building.getStreet());
		  buildingEntity.setWard(building.getWard());
		  DistrictEntity districtEntity= new DistrictEntity();
		  districtEntity.setId(building.getDistrictId());
		  buildingEntity.setDistrict(districtEntity);
		  entityManager.merge(buildingEntity);
		  System.out.println("ok");
	}
}


