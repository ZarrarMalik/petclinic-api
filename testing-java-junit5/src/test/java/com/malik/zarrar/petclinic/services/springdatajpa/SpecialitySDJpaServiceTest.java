package com.malik.zarrar.petclinic.services.springdatajpa;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import com.malik.zarrar.petclinic.model.Speciality;
import com.malilk.zarrar.petclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

	@Mock
	SpecialtyRepository specialtyRepository;
	@InjectMocks
	SpecialitySDJpaService specialitySDJpaService;

	@Test
	void findByIdTest() {
		Speciality speciality = new Speciality();

		when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

		Speciality foundSpecialty = specialitySDJpaService.findById(1L);

		assertThat(foundSpecialty).isNotNull();

		verify(specialtyRepository).findById(1L);

	}

	// BDD testing
	@Test
	void findByIdBddTest() {
		// given
		Speciality speciality = new Speciality();
		given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

		// when
		Speciality foundSpecialty = specialitySDJpaService.findById(1L);

		// then
		assertThat(foundSpecialty).isNotNull();
		then(specialtyRepository).should().findById(anyLong());
		then(specialtyRepository).shouldHaveNoMoreInteractions();
	}

	@Test
	void testDeleteByObject() {
		Speciality speciality = new Speciality();

		specialitySDJpaService.delete(speciality);

		verify(specialtyRepository).delete(any(Speciality.class));
	}

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

	@Test
	void testDoThrow() {
		doThrow(new RuntimeException("boom")).when(specialtyRepository).delete(any());

		assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

		verify(specialtyRepository).delete(any());
	}
}
