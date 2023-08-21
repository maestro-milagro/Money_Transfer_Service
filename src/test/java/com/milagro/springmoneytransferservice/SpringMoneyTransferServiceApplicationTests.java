package com.milagro.springmoneytransferservice;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.MTSUser;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringMoneyTransferServiceApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	private static final GenericContainer<?> myMTSApp = new GenericContainer<>("mymtsapp")
			.withExposedPorts(8100);

	@BeforeAll
	static void setUp() {
		myMTSApp.start();
	}

	@Test
	@Disabled
	void contextLoads() {
		String expectedOK = "200 OK";
		String expectedBedR = "400 BAD_REQUEST";

		ResponseEntity<String> responseEntityOK = restTemplate.postForEntity("http://localhost:" + 8100 +"/transfer", MTSOperation.builder()
				.cardFromNumber("1111111111111111")
				.cardFromCVV("598")
				.cardToNumber("1111111111111112")
				.cardFromValidTill("1127")
				.currency("RUB")
				.transferAmount(32131)
				.build()
				, String.class);
		ResponseEntity<String> responseEntityBedR = restTemplate.postForEntity("http://localhost:" + 8100 +"/transfer", MTSOperation.builder()
						.cardFromNumber("1111111111111113")
						.cardFromCVV("598")
						.cardToNumber("1111111111111112")
						.cardFromValidTill("1127")
						.currency("RUB")
						.transferAmount(32131)
						.build()
				, String.class);
		String resultOK = responseEntityOK.getStatusCode().toString();
		String resultBedR = responseEntityBedR.getStatusCode().toString();

		Assertions.assertEquals(expectedOK, resultOK);
		Assertions.assertEquals(expectedBedR, resultBedR);
	}


}
