package com.malik.zarrar.petclinic.services;

import java.util.List;

import com.malik.zarrar.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
