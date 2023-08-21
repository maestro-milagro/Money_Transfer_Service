package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    MTSUserRepository mtsUserRepository;

    @Test
    @Disabled
    void saveTest(){
        MTSUser mtsUser = MTSUser.builder()
                .cardFromNumber("1111111111111111")
                .cardFromCVV("598")
                .cardFromValidTill("1127")
                .firstName("Boris")
                .lastName("Britva")
                .accessCode("0000")
                .build();
        mtsUserRepository.save(mtsUser);

        MTSUser mtsUser2 = MTSUser.builder()
                .cardFromNumber("1111111111111112")
                .cardFromCVV("596")
                .cardFromValidTill("1166")
                .firstName("Tommy")
                .lastName("Gun")
                .accessCode("0000")
                .build();
        mtsUserRepository.save(mtsUser2);
    }
    @Test
    void findByCardNumberTest(){
        List<MTSUser> users = mtsUserRepository.findByCardFromNumber("1111111111111111");
        System.out.println(users);
        MTSUser mtsUser = MTSUser.builder()
                .userId(8)
                .cardFromNumber("1111111111111111")
                .cardFromCVV("598")
                .cardFromValidTill("1127")
                .firstName("Boris")
                .lastName("Britva")
                .accessCode("0000")
                .build();
        Assertions.assertEquals(users.get(0), mtsUser);
    }
    @Test
    void findByAccessCode(){
        List<MTSUser> list = mtsUserRepository.findByAccessCode("0000");
        Assertions.assertNotNull(list);
    }
}
