package com.malik.zarrar.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import com.malilk.zarrar.petclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

	@Mock
	VetRepository vetRepository;

	@InjectMocks
	VetSDJpaService service;

	@Test
	void testDeleteById() {
		service.deleteById(2L);
		verify(vetRepository).deleteById(2L);
	}

}
