package com.malik.zarrar.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class indexControllerTest {
	IndexController controller;

	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}

	@Test
	void testIndex() {
		assertEquals("index", controller.index());
		// This test takes extra argument and is lazy and only shows the message if not
		// satisfied
		assertEquals("index", controller.index(), "Wrong view returned");
		// assertEquals("indexd", controller.index(), () -> "Wrong message returned with
		// lambda");
		assertEquals("index", controller.index(), () -> "Wrong message returned with lambda");
	}

	@Test
	void testOupsHandler() {

		assertThrows(ValueNotFoundException.class, () -> {

			controller.oupsHandler();
		});
		// assertTrue("notimplemented".equalsIgnoreCase(controller.oupsHandler()), () ->
		// "Error -> test didn't pass");

	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOut() {

		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here");
		});
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOutPrempt() {

		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(5000);

			System.out.println("I got here 2342342342342");
		});
	}

}
