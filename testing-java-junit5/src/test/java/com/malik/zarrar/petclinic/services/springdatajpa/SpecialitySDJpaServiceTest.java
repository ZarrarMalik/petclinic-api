package com.malik.zarrar.petclinic.services.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malik.zarrar.petclinic.model.Speciality;
import com.malilk.zarrar.petclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

	@Mock
	SpecialtyRepository specialtyRepository;
	@InjectMocks
	SpecialitySDJpaService specialitySDJpaService;

	@Test
	void deleteById() {
		specialitySDJpaService.deleteById(1l);
	}

	@Test
	void testDelete() {
		specialitySDJpaService.delete(new Speciality());
	}
}
