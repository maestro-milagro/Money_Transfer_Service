package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.exceptions.InvalidOperationCode;
import com.milagro.springmoneytransferservice.exceptions.NoSuchCard;
import com.milagro.springmoneytransferservice.exceptions.NoSuchReceiver;
import com.milagro.springmoneytransferservice.model.MTSUser;
import com.milagro.springmoneytransferservice.repository.MTSUserRepository;
import com.milagro.springmoneytransferservice.service.MTSService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.List;
public class MTSServiceTests {
    MTSUserRepository mtsUserRepository = Mockito.mock(MTSUserRepository.class);
    MTSService service = new MTSService(mtsUserRepository);
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
        HttpStatus expected = HttpStatus.OK;
        String from = "";
        String to = "";
        Mockito.when(mtsUserRepository.findByCardFromNumber(from))
                .thenReturn(List.of(mtsUser));
        Mockito.when(mtsUserRepository.findByCardFromNumber(to))
                .thenReturn(List.of(mtsUser));

        HttpStatus result = (HttpStatus) service.checkForPresence(from, to).getStatusCode();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkForAccessTest() throws InvalidOperationCode {
        HttpStatus expected = HttpStatus.OK;
        String accessCode = "{\"code\":\"0000\"}";
        String parsedAccessCode= "0000";
        Mockito.when(mtsUserRepository.findByAccessCode(parsedAccessCode))
                .thenReturn(List.of(mtsUser));

        HttpStatus result = (HttpStatus) service.checkForAccess(accessCode).getStatusCode();

        Assertions.assertEquals(expected, result);
    }


}
