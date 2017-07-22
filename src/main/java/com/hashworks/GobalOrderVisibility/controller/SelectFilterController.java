package com.hashworks.GobalOrderVisibility.controller;

import com.hashworks.GobalOrderVisibility.model.enumeration.FilterTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by harshitha on 7/7/17.
 */
@RestController
@RequestMapping(value = "/api/gov/filter")
public class SelectFilterController {

    /*“filterType”:”Customer Number”
},
        {
        “filterId”:”2” ,
        “businessUnitName”:”Order Number ”
        },
        {
        “businessUnitId”:”3” ,
        “businessUnitName”:”Po Number”*/
    @RequestMapping(value = "/list")
    public ResponseEntity selectFilterType(){

       List res = new ArrayList();

        FilterTypes[] n = FilterTypes.values();

        for (int i = 0; i < n.length; i++) {
            Map map = new HashMap();
            map.put("filterId",i);
            map.put("filterType",n[i].name());
            res.add(map);
        }

        Map result = new HashMap();
        result.put("status","SUCCESS");
        result.put("region",res);

        return new  ResponseEntity(result, HttpStatus.OK);
    }

   /* @RequestMapping(value = "gov/lob/list")
    public ResponseEntity filter(@RequestBody String str){
        //obj.getString("fil");
    }*/
}
