package com.malik.zarrar.petclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
		
		assertThat(controller.index()).isEqualTo("index");
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

    @Test
    void testAssumptionTrue() {
    	//Tests passed even though the assumption failed
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
	
    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }
    
}
