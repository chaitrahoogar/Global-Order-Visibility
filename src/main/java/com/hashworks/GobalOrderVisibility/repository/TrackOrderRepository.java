package com.hashworks.GobalOrderVisibility.repository;

import com.hashworks.GobalOrderVisibility.model.TrackOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * Created by Preetesh on 7/10/2017.
 */

// join business_unit b on t.business_unit_id = b.id join lob l on t.lob_id = l.id join order_detail o on t.order_details_id = o.id join region r on t.region_id = r.id
@Repository
public interface TrackOrderRepository extends JpaRepository<TrackOrder,Long> {


  @Query(value = "select t.* from track_order t ",nativeQuery = true)
     List<TrackOrder> findAllByTrackOrderId(/*@Param("str") String str*/);

    /*@Query(value = "select t.* from track_order t where t.tie_number IN(1) AND t.business_unit_id IN (11,202) AND t.region_id IN(1,2) AND t.lob_id IN (1) AND t.order_details_id IN (11,22)",nativeQuery = true)
    List<TrackOrder> findAllByTrackOrderId();*/



}

