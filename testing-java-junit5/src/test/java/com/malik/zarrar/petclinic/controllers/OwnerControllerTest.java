package com.malik.zarrar.petclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malik.zarrar.petclinic.fauxspring.BindingResult;
import com.malik.zarrar.petclinic.model.Owner;
import com.malik.zarrar.petclinic.services.OwnerService;

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
	
	private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_5 = "redirect:/owners/1";
	
	@Test
	void testProcessCreationForm_HasErrors() {
		when(bindingResult.hasErrors()).thenReturn(true);
		String viewName = controller.processCreationForm(owner, bindingResult);
		assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
		verify(bindingResult).hasErrors();
	}
	
	@Test
	void testProcessCreationForm_HasNoErrors() {
		when(bindingResult.hasErrors()).thenReturn(false);
		when(ownerService.save(any())).thenReturn(owner);
		Long value = 1L;
		when(owner.getId()).thenReturn(value );
		String viewName = controller.processCreationForm(owner, bindingResult);
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
		verify(bindingResult).hasErrors();
		verify(ownerService).save(any());
		verify(owner).getId();
		verifyNoMoreInteractions(owner, ownerService);
	}

}
