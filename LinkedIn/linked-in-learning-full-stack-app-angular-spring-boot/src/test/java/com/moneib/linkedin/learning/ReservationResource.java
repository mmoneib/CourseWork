package com.moneib.linkedin.learning;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.moneib.linkedin.learning.rest.ResourceConstants;

import io.restassured.RestAssured;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = LinkedInLearningFullStackAppAngularSpringBootApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReservationResource {
	// Used in conjubnction with the specified web environment.
	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = Integer.valueOf(port);
		RestAssured.basePath = ResourceConstants.ROOM_RESERVATION_V1;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	public void test() {
		// Test for room with id = 1;
		// It gets the endpoint info from the setUp() method.
		given().when().get("/" + 1).then().statusCode(200);
	}

}
