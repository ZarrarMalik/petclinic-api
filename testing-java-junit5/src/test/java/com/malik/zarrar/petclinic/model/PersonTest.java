package com.malik.zarrar.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

	Person person = new Person(2L, "Joe", "Black");
	
	@Test
	void testGroupedAssertions() {
		// Uses multiple asserts in a single test with lambdas
		assertAll("Test Prop set", ()-> assertEquals("Joe", person.getFirstName()),
				()->assertEquals("Black", person.getLastName()));
	}
	
	@Test
	void testGroupedAssertionsWithMessages() {
		// Uses multiple asserts in a single test with lambdas
		assertAll("Test Prop set", ()-> assertEquals("Joe", person.getFirstName(), "First Name failed"),
				() -> assertEquals("Black", person.getLastName(), "Second Name failed"));
	}

}
