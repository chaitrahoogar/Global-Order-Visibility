package com.hashworks.GobalOrderVisibility.serviceImpl;

import com.hashworks.GobalOrderVisibility.model.LOB;
import com.hashworks.GobalOrderVisibility.repository.LOBRepository;
import com.hashworks.GobalOrderVisibility.service.LOBService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by Preetesh on 7/10/2017.
 */

@Service
public class LOBServiceImpl implements LOBService {

    @Autowired
    private LOBRepository lobRepository;

    //method to get all LOB list from LOB table


    @Override
    public Map listAllLOB() {

        Map lobTypeMap = null;
        Map result = new HashMap();
        List<Map> lobList = new ArrayList<>();


        try {
            List<LOB> list = this.lobRepository.findAll();

            for (LOB lob : list) {
                lobTypeMap = new LinkedHashMap();
                lobTypeMap.put("lobId", lob.getId());
                lobTypeMap.put("lobsName", lob.getLobsName());

                lobList.add(lobTypeMap);
            }

            if (lobList.size() != 0) {

                result.put("status", "success");
                result.put("lob", lobList);

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
