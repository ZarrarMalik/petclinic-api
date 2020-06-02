package com.malik.zarrar.petclinic.services.springdatajpa;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		specialitySDJpaService.deleteById(1l);

		verify(specialtyRepository, times(2)).deleteById(1l);
	}

	@Test
	void deleteByIdAtLeast() {
		specialitySDJpaService.deleteById(1l);
		specialitySDJpaService.deleteById(1l);

		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
	}

	@Test
	void deleteByIdAtMost() {
		specialitySDJpaService.deleteById(1l);
		specialitySDJpaService.deleteById(1l);

		verify(specialtyRepository, atMost(5)).deleteById(1l);
	}

	@Test
	void deleteByIdNever() {
		specialitySDJpaService.deleteById(1l);
		specialitySDJpaService.deleteById(1l);

		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
	}

	@Test
	void testDelete() {
		specialitySDJpaService.delete(new Speciality());
	}
}
