package services;

import model.Pet;

import java.security.acl.Owner;
import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
