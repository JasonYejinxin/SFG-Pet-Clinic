package jason.springframework.sfgpetclinic.services;

import jason.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
