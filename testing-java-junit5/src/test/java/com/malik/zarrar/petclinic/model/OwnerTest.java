package com.malik.zarrar.petclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OwnerTest {

	// Owner extends to person, so we need both set of properties
	@Test
	void dependentAssertions() {

		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("1231231234");

		// We have mulitple layers of assertAll
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
						() -> assertEquals("Buck", owner.getLastName())),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
						() -> assertEquals("1231231234", owner.getTelephone())));
		// Hamcrest assertThat
		assertThat(owner.getCity(), is("Key West"));
	}

	@DisplayName("Value Source Test")
	// params dependency
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// displayname palceholder is "value source test", index is 1,2, 3 in this case
	// arguments are acutal string values spring, framework, guru
	@ValueSource(strings = { "Spring", "Framework", "Guru" })
	void testValueSource(String val) {
		//Prints spring, framework and guru
		System.out.println(val);
	}

}
