package com.milagro.springmoneytransferservice.controller;


import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MTSController {
    @Autowired
    MTSService mtsService;
    @CrossOrigin
    @PostMapping("/transfer")
    public ResponseEntity<String> returnMessege(@RequestBody MTSOperation mtsOperation) throws NoSuchCard, NoSuchReceiver {
//        System.out.println(mtsOperation);
//        return new ResponseEntity<>("Success transfer", HttpStatus.OK);
        mtsOperation.setTransferAmount(mtsOperation.getTransferAmount()/100);
        mtsService.saveOperation(mtsOperation);
        return mtsService.checkForPresence(mtsOperation.getCardFromNumber(), mtsOperation.getCardToNumber());
    }
    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<String> returnMessege2(@RequestBody String operationId) throws InvalidOperationCode {
//        System.out.println(operationId);
        return mtsService.checkForAccess(operationId);
//        return new ResponseEntity<>("Success transfer", HttpStatus.OK);
    }
    @PostMapping("/1")
    public ResponseEntity<String> tr(@RequestBody MTSUser mtsUser) throws NoSuchCard, NoSuchReceiver {
        return mtsService.save1(mtsUser);
    }
}
