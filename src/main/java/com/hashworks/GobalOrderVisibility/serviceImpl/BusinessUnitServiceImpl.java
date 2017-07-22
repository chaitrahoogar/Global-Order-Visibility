package com.hashworks.GobalOrderVisibility.serviceImpl;

import com.hashworks.GobalOrderVisibility.model.BusinessUnit;
import com.hashworks.GobalOrderVisibility.model.LOB;
import com.hashworks.GobalOrderVisibility.repository.BusinessUnitRepository;
import com.hashworks.GobalOrderVisibility.service.BusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Preetesh on 7/10/2017.
 */

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService{
    @Autowired
    public BusinessUnitRepository businessUnitRepository;

    @Override
    public Map listAllBusinessUnit(){

        Map buMap = null;
        Map result = new HashMap();
        List<Map> buList = new ArrayList<>();


        try {
            List<BusinessUnit> list = this.businessUnitRepository.findAll();

            for (BusinessUnit uList  : list) {
                buMap = new LinkedHashMap();
                buMap.put("businessUnitId", uList.getId());
                buMap.put("businessUnitName", uList.getBusinessUnitName());

                buList.add(buMap);
            }

            if (buList.size() != 0) {

                result.put("status", "success");
                result.put("businessunit", buList);

            } else {
                result.put("message", "no records found");
            }
            return result;


        } catch (Exception e) {

            result.put("status", "failure");
            result.put("message", "Failed to fetch the list");
            return result;

        }



    }
}
