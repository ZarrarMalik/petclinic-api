package com.malik.zarrar.petclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.malik.zarrar.petclinic.args.CustomArgsProvider;

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
		// Prints spring, framework and guru
		System.out.println(val);
	}

	@DisplayName("Enum Source Test")
	// params dependency
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// displayname palceholder is "value source test", index is 1,2, 3 in this case
	// All enums are iterated here in ownertype class
	@EnumSource(OwnerType.class)
	void testEnumSource(OwnerType ownerType) {
		// Prints spring, framework and guru
		System.out.println(ownerType);
	}

	@DisplayName("CSV Input Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// Reads value from the source
	@CsvSource({ "FL, 1, 1", "OH, 2, 2", "MI, 3, 1" })
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	@DisplayName("CSV From File Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// Reads value from resources input.csv file
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
	void csvFromFileTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	@DisplayName("Method Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// This test takes in a static method getargs and uses its objects
	@MethodSource("getargs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	static Stream<Arguments> getargs() {
		return Stream.of(Arguments.of("FL", 5, 1), Arguments.of("OH", 2, 8), Arguments.of("MI", 3, 5));
	}

	@DisplayName("Custom Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	// This test uses custom args provider class as argument similar to above test
	// but uses a class
	@ArgumentsSource(CustomArgsProvider.class)
	void fromCustomProviderTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
}
