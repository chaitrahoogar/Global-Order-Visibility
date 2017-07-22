package com.hashworks.GobalOrderVisibility.controller;

import com.hashworks.GobalOrderVisibility.repository.TrackOrderRepository;
import com.hashworks.GobalOrderVisibility.service.TrackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Preetesh on 7/11/2017.
 */
@RestController
@RequestMapping(value = "/api/gov/track/order/")
public class TrackOrderController {

@Autowired
public TrackOrderService trackOrderService;


    @RequestMapping(value = "list",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllOrder(@RequestBody String str){
        try {
            System.out.println("str : "+str);

            return new ResponseEntity(this.trackOrderService.listTrackOrder(str), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}
