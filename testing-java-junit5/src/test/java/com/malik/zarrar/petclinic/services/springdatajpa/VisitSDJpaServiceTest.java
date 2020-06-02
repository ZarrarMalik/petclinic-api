package com.malik.zarrar.petclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malik.zarrar.petclinic.model.Visit;
import com.malilk.zarrar.petclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

	@Mock
	VisitRepository visitRepository;

	@InjectMocks
	VisitSDJpaService service;

	@Test
	void testFindAll() {
		Set<Visit> visits = new HashSet<>();
		visits.add(new Visit());
		when(visitRepository.findAll()).thenReturn(visits);
		assertThat(service.findAll()).isNotEmpty();
		verify(visitRepository).findAll();
	}

	@Test
	void testFindById() {
		Visit visit = mock(Visit.class);
		when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
		assertThat(service.findById(1L)).isNotNull();
		verify(visitRepository).findById(anyLong());
	}

	@Test
	void testSave() {
		Visit visit = mock(Visit.class);
		when(visitRepository.save(any())).thenReturn(visit);
		assertThat(service.save(visit)).isIn(visit);
		verify(visitRepository).save(any());

	}

	@Test
	void testDelete() {
		Visit visit = mock(Visit.class);
		service.delete(visit);
		verify(visitRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(anyLong());
		verify(visitRepository).deleteById(anyLong());
	}

}
