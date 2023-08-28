package com.milagro.springmoneytransferservice.controller;


import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.ResponseDTO;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoneyTransferServiceController {
    private final MTSService mtsService;
    @Autowired
    public MoneyTransferServiceController(MTSService mtsService){
        this.mtsService = mtsService;
    }
    @CrossOrigin
    @PostMapping("/transfer")
    public ResponseEntity<ResponseDTO> returnMessege(@RequestBody MTSOperation mtsOperation) throws NoSuchCard, NoSuchReceiver {
        mtsOperation.setTransferAmount(mtsOperation.getTransferAmount()/100);
        mtsService.saveOperation(mtsOperation);
        return new ResponseEntity<>(mtsService.checkForPresence(mtsOperation.getCardFromNumber(), mtsOperation.getCardToNumber()), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<ResponseDTO> returnMessege2(@RequestBody String operationId) throws InvalidOperationCode {
        return new ResponseEntity<>(mtsService.checkForAccess(operationId), HttpStatus.OK);
    }
}
