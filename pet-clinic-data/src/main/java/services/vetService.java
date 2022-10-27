package services;

import model.Vet;

import java.security.acl.Owner;
import java.util.Set;

public interface vetService {

    Vet findById(Long id);

    Vet save(Owner owner);

    Set<Vet> findAll();
}
