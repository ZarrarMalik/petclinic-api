package com.malik.zarrar.petclinic.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.malik.zarrar.petclinic.fauxspring.BindingResult;
import com.malik.zarrar.petclinic.fauxspring.WebDataBinder;
import com.malik.zarrar.petclinic.model.Pet;
import com.malik.zarrar.petclinic.model.Visit;
import com.malik.zarrar.petclinic.services.PetService;
import com.malik.zarrar.petclinic.services.VisitService;

public class VisitController {
	private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    public String initNewVisitForm(Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
