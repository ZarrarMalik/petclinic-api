package com.malik.zarrar.petclinic.inline.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationMockTests {
	@Mock
	Map<String, Object> mockMap;

	@Test
	void testMock() {
		mockMap.put("keyvalue", "foo");
	}
}
