package com.malik.zarrar.petclinic.controllers;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oupsHandler() throws ValueNotFoundException{
    	throw new ValueNotFoundException();
     //   return "notimplemented";
    }
	
}
