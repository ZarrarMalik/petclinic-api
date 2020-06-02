package com.malik.zarrar.petclinic.inline.mock;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnnotationMockWIthExtensionTests {
	@Mock
	Map<String, Object> mockMap;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testMock() {
		mockMap.put("keyvalue", "foo");
	}
}
