package com.milagro.springmoneytransferservice.service;

import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MTSService {
    @Autowired
    MTSOperationRepository mtsOperationRepository;

//    public String getName(String)
}
