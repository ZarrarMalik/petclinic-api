package com.malik.zarrar.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class PersonTest {

	Person person = new Person(2L, "Joe", "Black");

	@Test
	void testGroupedAssertions() {
		// Uses multiple asserts in a single test with lambdas
		assertAll("Test Prop set", () -> assertEquals("Joe", person.getFirstName()),
				() -> assertEquals("Black", person.getLastName()));
	}

	@Test
	void testGroupedAssertionsWithMessages() {
		// Uses multiple asserts in a single test with lambdas
		assertAll("Test Prop set", () -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
				() -> assertEquals("Black", person.getLastName(), "Second Name failed"));
	}

	// Repeats test 10 times
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My Repeated Test")
	//@Test drop test annotation with repeated tests
	void testRepeatedTest() {

	}

}
