package jason.springframework.sfgpetclinic.bootstrap;

import jason.springframework.sfgpetclinic.model.Owner;
import jason.springframework.sfgpetclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jason.springframework.sfgpetclinic.services.OwnerService;
import jason.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Jinxin");
        owner1.setLastName("Ye");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jingwen");
        owner2.setLastName("Zhang");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Andy");
        vet1.setLastName("Gao");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Xingyu");
        vet2.setLastName("Li");
        vetService.save(vet2);

        System.out.println("Loaded Vets");

    }
}
