package com.nguyenhung.repository;

import java.util.List;
import java.util.Map;

import com.nguyenhung.builder.BuildingSearchBuilder;
import com.nguyenhung.repository.entity.BuildingEntity;
public interface BuildingRespository {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
