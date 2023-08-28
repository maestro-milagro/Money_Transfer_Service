package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.repository.MTSOperationRepository;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.List;
public class MTSServiceTests {
    MTSUserRepository mtsUserRepository = Mockito.mock(MTSUserRepository.class);
    MTSOperationRepository mtsOperationRepository = Mockito.mock(MTSOperationRepository.class);
    MTSService service = new MTSService(mtsUserRepository, mtsOperationRepository);
    MTSUser mtsUser = MTSUser.builder()
            .userId(0)
            .cardFromNumber("1111111111111112")
            .cardFromCVV("596")
            .cardFromValidTill("1166")
            .firstName("Tommy")
            .lastName("Gun")
            .accessCode("0000")
            .build();
    @Test
    public void checkForPresence() throws NoSuchCard, NoSuchReceiver {
        String expected = "0000";
        String from = "";
        String to = "";
        Mockito.when(mtsUserRepository.findByCardFromNumber(from))
                .thenReturn(List.of(mtsUser));
        Mockito.when(mtsUserRepository.findByCardFromNumber(to))
                .thenReturn(List.of(mtsUser));

        String result = service.checkForPresence(from, to).getOperationId();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkForAccessTest() throws InvalidOperationCode {
        String expected = "0000";
        String accessCode = "{\"code\":\"0000\"}";
        String parsedAccessCode= "0000";
        Mockito.when(mtsUserRepository.findByAccessCode(parsedAccessCode))
                .thenReturn(List.of(mtsUser));

        String result = service.checkForAccess(accessCode).getOperationId();

        Assertions.assertEquals(expected, result);
    }


}
