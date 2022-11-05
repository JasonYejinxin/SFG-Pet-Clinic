package services;

import model.Owner;
import model.Person;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
