package com.hashworks.GobalOrderVisibility.repository;

import com.hashworks.GobalOrderVisibility.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by harshitha on 7/7/17.
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>
{

}
