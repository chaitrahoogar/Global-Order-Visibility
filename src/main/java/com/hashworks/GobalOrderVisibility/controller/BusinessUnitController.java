package com.hashworks.GobalOrderVisibility.controller;

import com.hashworks.GobalOrderVisibility.service.BusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Preetesh on 7/10/2017.
 */

@RestController
@RequestMapping(value = "/api/gov/business")
public class BusinessUnitController {

    @Autowired
    public BusinessUnitService businessUnitService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllBusinessUnits(){

        try{
            return new ResponseEntity<Object>(this.businessUnitService.listAllBusinessUnit(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
