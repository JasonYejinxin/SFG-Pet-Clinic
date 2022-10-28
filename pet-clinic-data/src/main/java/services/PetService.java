package services;

import model.Pet;

public interface PetService extends CrudService<Pet,Long> {

    Pet findById(Long id);

}
