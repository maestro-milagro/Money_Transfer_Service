package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    MTSUserRepository mtsUserRepository;

    @Test
    void saveTest(){
        MTSUser mtsUser = MTSUser.builder()
                .cardFromNumber("4355555555")
                .cardFromCVV("598")
                .cardFromValidTill("34214")
                .firstName("Boris")
                .lastName("Britva")
                .build();
        mtsUserRepository.save(mtsUser);
    }
    @Test
    void findByCardNumberTest(){
        List<MTSUser> users = mtsUserRepository.findByCardFromNumber("4355555555");
        System.out.println(users);
    }
}
