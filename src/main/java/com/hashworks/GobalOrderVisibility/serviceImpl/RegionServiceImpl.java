package com.hashworks.GobalOrderVisibility.serviceImpl;

import com.hashworks.GobalOrderVisibility.model.LOB;
import com.hashworks.GobalOrderVisibility.model.Region;
import com.hashworks.GobalOrderVisibility.repository.RegionRepository;
import com.hashworks.GobalOrderVisibility.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Preetesh on 7/10/2017.
 */

@Service
public class RegionServiceImpl implements RegionService{

@Autowired
    public RegionRepository regionRepository;

@Override
    public Map listAllRegion(){

    Map regionTypeMap = null;
    Map result = new HashMap();
    List<Map> regionList = new ArrayList<>();


    try {
        List<Region> list = this.regionRepository.findAll();

        for (Region region : list) {
            regionTypeMap = new LinkedHashMap();
            regionTypeMap.put("regionId", region.getId());
            regionTypeMap.put("regionName",region.getRegionName());
            regionTypeMap.put("regionCode",region.getRegionCode());

            regionList.add(regionTypeMap);
        }

        if (regionList.size() != 0) {

            result.put("status", "success");
            result.put("lob", regionList);

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
