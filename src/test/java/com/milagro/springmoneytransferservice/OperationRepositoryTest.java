package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@DataJpaTest
public class OperationRepositoryTest {
    @Autowired
    private MTSOperationRepository mtsOperationRepository;

    @Test
    @Disabled
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
    @Test
    void findTest(){
        List<MTSOperation> listFrom = mtsOperationRepository.findByCardFromNumber("4355555555");
        List<MTSOperation> listTo = mtsOperationRepository.findByCardToNumber("544444443");

        Assertions.assertEquals(listFrom,listTo);
    }
    @Test
    void notFindTest(){
        List<MTSOperation> listFrom = new ArrayList<>();
        List<MTSOperation> listTo = mtsOperationRepository.findByCardToNumber("544444447");

        Assertions.assertEquals(listTo, listFrom);
    }
}
