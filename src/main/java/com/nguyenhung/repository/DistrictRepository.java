package com.nguyenhung.repository;

import com.nguyenhung.repository.entity.DistrictEntity;

public interface DistrictRepository {
   DistrictEntity findNameById (Long id);
}
