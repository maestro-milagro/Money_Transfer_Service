package com.milagro.springmoneytransferservice.service;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.ResponseDTO;
import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
public class MTSService {
    private MTSUserRepository mtsUserRepository;
    private MTSOperationRepository mtsOperationRepository;
    @Autowired
    public MTSService(MTSUserRepository mtsUserRepository, MTSOperationRepository mtsOperationRepository){
        this.mtsUserRepository = mtsUserRepository;
        this.mtsOperationRepository = mtsOperationRepository;
    }
    @Transactional
    public ResponseDTO checkForPresence(String from, String to) throws NoSuchCard, NoSuchReceiver {
        if (mtsUserRepository.findByCardFromNumber(from).isEmpty()){
            log.error("No user card with this number");
            throw new NoSuchCard("No user card with this number");
        } else if(mtsUserRepository.findByCardFromNumber(to).isEmpty()){
            log.error("No receiver card with this number");
            throw new NoSuchReceiver("No receiver card with this number");
        }
        log.info("Presence check passed");
        return new ResponseDTO("0000");
    }
    @Transactional
    public void saveOperation(MTSOperation mtsOperation) throws NoSuchCard, NoSuchReceiver {
        if (checkForPresence(mtsOperation.getCardFromNumber(),mtsOperation.getCardToNumber()).getOperationId().equals("0000")) {
            log.info("Operation saved");
            log.info(mtsOperation.toString());
            mtsOperationRepository.save(mtsOperation);
        }
    }
    @Transactional
    public ResponseDTO checkForAccess(String accessCode) throws InvalidOperationCode {
        String parsedAccessCode = accessCode.replaceAll("\"code\":\"", "").replaceAll("\"","").replaceAll("}", "").substring(1);
        if (mtsUserRepository.findByAccessCode(parsedAccessCode).isEmpty()){
            log.error("Invalid operation code for this user");
            throw new InvalidOperationCode("Invalid operation code for this user");
        }
        log.info("Access check passed");
        return new ResponseDTO("0000");

    }

}
