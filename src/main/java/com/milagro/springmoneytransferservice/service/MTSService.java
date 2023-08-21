package com.milagro.springmoneytransferservice.service;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
public class MTSService {
    @Autowired
    MTSUserRepository mtsUserRepository;
    @Autowired
    MTSOperationRepository mtsOperationRepository;

    public MTSService(MTSUserRepository mtsUserRepository){
        this.mtsUserRepository = mtsUserRepository;
    }

    public ResponseEntity<String> checkForPresence(String from, String to) throws NoSuchCard, NoSuchReceiver {
        if (mtsUserRepository.findByCardFromNumber(from).isEmpty()){
            log.error("No user card with this number");
//            System.out.println("from");
            throw new NoSuchCard("No user card with this number");
        } else if(mtsUserRepository.findByCardFromNumber(to).isEmpty()){
            log.error("No receiver card with this number");
//            System.out.println("to");
            throw new NoSuchReceiver("No receiver card with this number");
        }
        log.info("Presence check passed");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public void saveOperation(MTSOperation mtsOperation) throws NoSuchCard, NoSuchReceiver {
        if (checkForPresence(mtsOperation.getCardFromNumber(),mtsOperation.getCardToNumber()).getStatusCode().equals(HttpStatus.OK)) {
            log.info("Operation saved");
            log.info(mtsOperation.toString());
            mtsOperationRepository.save(mtsOperation);
        }
    }

    public ResponseEntity<String> checkForAccess(String accessCode) throws InvalidOperationCode {
        String parsedAccessCode = accessCode.replaceAll("\"code\":\"", "").replaceAll("\"","").replaceAll("}", "").substring(1);
        if (mtsUserRepository.findByAccessCode(parsedAccessCode).isEmpty()){
            log.error("Invalid operation code for this user");
            throw new InvalidOperationCode("Invalid operation code for this user");
        }
        log.info("Access check passed");
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }
    public ResponseEntity<String> save1(MTSUser mtsUser) throws NoSuchCard, NoSuchReceiver {
        mtsUserRepository.save(mtsUser);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
