package com.malik.zarrar.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malik.zarrar.petclinic.fauxspring.BindingResult;
import com.malik.zarrar.petclinic.model.Owner;
import com.malik.zarrar.petclinic.services.OwnerService;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	Owner owner;
	@Mock
	BindingResult bindingResult;
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController controller;
	
	
	@Test
	void testProcessCreationForm_HasErrors() {
		when(bindingResult.hasErrors()).thenReturn(true);
		assertThat(controller.processCreationForm(owner, bindingResult)).isNotNull();
		verify(bindingResult).hasErrors();
	}
	
	@Test
	void testProcessCreationForm_HasNoErrors() {
		when(bindingResult.hasErrors()).thenReturn(false);
		when(ownerService.save(any())).thenReturn(owner);
		Long value = 1L;
		when(owner.getId()).thenReturn(value );
		assertThat(controller.processCreationForm(owner, bindingResult)).isNotNull();
		verify(bindingResult).hasErrors();
		verify(ownerService).save(any());
		verify(owner).getId();
		verifyNoMoreInteractions(owner, ownerService);
	}

}
