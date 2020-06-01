package com.malik.zarrar.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import com.malik.zarrar.petclinic.fauxspring.Model;
import com.malik.zarrar.petclinic.fauxspring.ModelMapImpl;
import com.malik.zarrar.petclinic.model.Speciality;
import com.malik.zarrar.petclinic.model.Vet;
import com.malik.zarrar.petclinic.services.SpecialtyService;
import com.malik.zarrar.petclinic.services.VetService;
import com.malik.zarrar.petclinic.services.map.SpecialityMapService;
import com.malik.zarrar.petclinic.services.map.VetMapService;

class VetControllerTest {

	VetService vetService;
	SpecialtyService specialtyService;

	VetController vetController;
	@BeforeEach
	void setUp() throws Exception {
		
		specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);
        
        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
		
	}

	@Test
	void testVetController() {
	//	fail("Not yet implemented");
	}

	@Test
	void testListVets() {
	Model model = new ModelMapImpl();
	String view = vetController.listVets(model);
	assertThat("vets/index").isEqualTo(view);
	
	Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

    assertThat(modelAttribute.size()).isEqualTo(2);
	}

}
