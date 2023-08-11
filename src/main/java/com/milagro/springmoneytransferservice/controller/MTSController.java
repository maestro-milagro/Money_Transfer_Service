package com.milagro.springmoneytransferservice.controller;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MTSController {
    @Autowired
    MTSService mtsService;
    @PostMapping("https://serp-ya.github.io/card-transfer")
    public ResponseEntity<String> returnMessege(MTSOperation operation){
        System.out.println(operation.toString());
        return new ResponseEntity<>("балдёж", HttpStatus.OK);
    }
}
