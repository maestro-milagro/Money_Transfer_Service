package com.milagro.springmoneytransferservice.service;

import com.milagro.springmoneytransferservice.repository.MTSRepository;
import org.springframework.stereotype.Service;

@Service
public class MTSService {
    MTSRepository mtsRepository;
    public MTSService(MTSRepository mtsRepository){
        this.mtsRepository = mtsRepository;
    }
//    public String getName(String)
}
