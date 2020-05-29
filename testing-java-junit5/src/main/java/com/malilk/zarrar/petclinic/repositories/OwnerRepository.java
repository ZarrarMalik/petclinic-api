package com.malilk.zarrar.petclinic.repositories;

import java.util.List;

import com.malik.zarrar.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
