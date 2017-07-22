package com.hashworks.GobalOrderVisibility.repository;

import com.hashworks.GobalOrderVisibility.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Preetesh on 7/10/2017.
 */
@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
}
