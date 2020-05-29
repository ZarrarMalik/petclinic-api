package com.malik.zarrar.petclinic.controllers;

import com.malik.zarrar.petclinic.fauxspring.Model;
import com.malik.zarrar.petclinic.services.VetService;

public class VetController {
	private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
