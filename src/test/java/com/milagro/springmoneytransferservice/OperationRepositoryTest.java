package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OperationRepositoryTest {
    @Autowired
    private MTSOperationRepository mtsOperationRepository;

    @Test
    void saveTest(){
        MTSOperation mtsOperation = MTSOperation.builder()
                .cardFromNumber("4355555555")
                .cardFromCVV("543")
                .cardToNumber("544444443")
                .cardFromValidTill("34214")
                .currency("RUB")
                .transferAmount(32131)
                .build();
        mtsOperationRepository.save(mtsOperation);
    }

}
