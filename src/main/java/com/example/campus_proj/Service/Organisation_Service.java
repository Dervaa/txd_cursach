package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Organisation;
import com.example.campus_proj.repository.IOrganisation_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Organisation_Service {
    private final IOrganisation_repo organisationRepo;

    @Autowired
    public Organisation_Service(IOrganisation_repo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }

    @Async
    public List<Organisation> getAllOrganisations() {
        return organisationRepo.findAll();
    }

    @Async
    public Optional<Organisation> getById(Long id) {
        return organisationRepo.findById(id);
    }

    public void deleteOrganisationById(Long id) {
        long count = organisationRepo.count();
        if (count > 1) {
            organisationRepo.deleteById(id);
        } else {
            throw new UnsupportedOperationException("Cannot delete the last instance of Organisation.");
        }
    }

    public void create(Organisation organisation) {
        organisationRepo.save(organisation);
    }

    public void update(Organisation organisation) {
        Optional<Organisation> optionalOrganisation = getById(organisation.getId());
        optionalOrganisation.ifPresent(existingOrganisation -> {
            existingOrganisation.setName(organisation.getName());
            existingOrganisation.setAmount_of_people(organisation.getAmount_of_people());
            existingOrganisation.setOrg_bill(organisation.getOrg_bill());
        });
    }
    public Optional<Organisation> getByOrganisationName(String name){
        return Optional.ofNullable(organisationRepo.findFirstByName(name));
    }
    public Optional<Organisation> getByAmount(Integer amount_of_people){
        return Optional.ofNullable(organisationRepo.findFirstByAmount(amount_of_people));
    }
}

