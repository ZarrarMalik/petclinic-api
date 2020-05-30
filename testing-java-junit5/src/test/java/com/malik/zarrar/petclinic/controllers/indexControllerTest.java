package com.malik.zarrar.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
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
	//	assertEquals("indexd", controller.index(), () -> "Wrong message returned with lambda");
		assertEquals("index", controller.index(), () -> "Wrong message returned with lambda");
	}

	@Test
	void testOupsHandler() {
		
		assertThrows(ValueNotFoundException.class, ()-> { 
			
		controller.oupsHandler();
		});
	//	assertTrue("notimplemented".equalsIgnoreCase(controller.oupsHandler()), () -> "Error -> test didn't pass");

	}

}
