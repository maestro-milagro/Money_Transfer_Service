package com.milagro.springmoneytransferservice.controller;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MTSController {
    MTSService mtsService;
    public MTSController(MTSService mtsService){
        this.mtsService = mtsService;
    }
    @PostMapping("https://serp-ya.github.io/card-transfer/")
    public String returnMessege(MTSOperation operation){
        return null;
    }
}
