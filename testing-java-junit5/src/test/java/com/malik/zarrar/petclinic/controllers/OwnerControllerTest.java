package com.malik.zarrar.petclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malik.zarrar.petclinic.fauxspring.BindingResult;
import com.malik.zarrar.petclinic.fauxspring.Model;
import com.malik.zarrar.petclinic.model.Owner;
import com.malik.zarrar.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	Owner owner;
	
	@Mock
	OwnerService ownerService;
	@Mock
	Model model;

	@InjectMocks
	OwnerController controller;

	@Mock
	BindingResult bindingResult;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
	private static final String REDIRECT_OWNERS_5 = "redirect:/owners/1";

	 @BeforeEach
	    void setUp() {
		 
	 }
	
	
	@Test
	void processFindFormWildcardString() {
		// given
		Owner owner = new Owner(1l, "Joe", "Buck");
		List<Owner> ownerList = new ArrayList<>();
		final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		// given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);
		when(ownerService.findAllByLastNameLike(captor.capture())).thenReturn(ownerList);

		// when
		String viewName = controller.processFindForm(owner, bindingResult, null);

		// then
		assertThat("%Buck%").isEqualToIgnoringCase(captor.getValue());
		
	}

	@Test
	void processFindFormWildcardStringAnnotation() {
		// given
		Owner owner = new Owner(1l, "Joe", "Buck");
		// You can define what order you want your mocks to go in with Inorder and 
		//Verify them at the end...to make sure thye are in order
		InOrder inOrder = Mockito.inOrder(ownerService, model);
		List<Owner> ownerList = new ArrayList<>();
		when(ownerService.findAllByLastNameLike(stringArgumentCaptor.capture())).thenReturn(ownerList);

		// when
		String viewName = controller.processFindForm(owner, bindingResult, null);

		// then
		assertThat("%Buck%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
		
		  // inorder asserts
		
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
       // inOrder.verify(model).addAttribute(anyString(), anyList());
       
	}

	@Test
	void testProcessCreationForm_HasErrors() {
		when(bindingResult.hasErrors()).thenReturn(true);
		String viewName = controller.processCreationForm(owner, bindingResult);
		assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
		verify(bindingResult).hasErrors();
		Mockito.verifyZeroInteractions(model);
	}

	@Test
	void testProcessCreationForm_HasNoErrors() {
		when(bindingResult.hasErrors()).thenReturn(false);
		when(ownerService.save(any())).thenReturn(owner);
		Long value = 1L;
		when(owner.getId()).thenReturn(value);
		String viewName = controller.processCreationForm(owner, bindingResult);
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
		verify(bindingResult).hasErrors();
		verify(ownerService).save(any());
		verify(owner).getId();
		verifyNoMoreInteractions(owner, ownerService);
		Mockito.verifyZeroInteractions(model);
	}

}
