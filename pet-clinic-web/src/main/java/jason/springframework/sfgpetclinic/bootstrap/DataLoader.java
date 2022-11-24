package jason.springframework.sfgpetclinic.bootstrap;

import jason.springframework.sfgpetclinic.model.*;
import jason.springframework.sfgpetclinic.services.PetTypeService;
import jason.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jason.springframework.sfgpetclinic.services.OwnerService;
import jason.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if( count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jinxin");
        owner1.setLastName("Ye");
        owner1.setAddress("448 Rosedale Ave");
        owner1.setCity("Windsor");
        owner1.setTelephone("2498706870");
        ownerService.save(owner1);

        Pet JinxinsPet = new Pet();
        JinxinsPet.setPetType(saveCatPetType);
        JinxinsPet.setOwner(owner1);
        JinxinsPet.setBirthDate(LocalDate.now());
        JinxinsPet.setName("mimi");
        owner1.getPets().add(JinxinsPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jingwen");
        owner2.setLastName("Zhang");
        owner2.setAddress("721 Partington Ave");
        owner2.setCity("Windsor");
        owner2.setTelephone("2268700577");
        ownerService.save(owner2);

        Pet JingwensPet = new Pet();
        JingwensPet.setPetType(saveDogPetType);
        JingwensPet.setOwner(owner2);
        JingwensPet.setBirthDate(LocalDate.now());
        JingwensPet.setName("gougou");
        owner1.getPets().add(JingwensPet);


        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Andy");
        vet1.setLastName("Gao");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Xingyu");
        vet2.setLastName("Li");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
