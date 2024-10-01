package com.nguyenhung.repository;

import java.util.List;

import com.nguyenhung.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
      List<RentAreaEntity> findByBuildingId(long id);
}
