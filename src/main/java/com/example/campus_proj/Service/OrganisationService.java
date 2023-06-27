package com.example.campus_proj.Service;

import com.example.campus_proj.Entity.Organisation;
import com.example.campus_proj.repository.IOrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrganisationService {
    @Autowired
    IOrganisationRepository iOrganisationRepository;

    @Async
    public List<Organisation> getAll(){
        return iOrganisationRepository.findAll();
    }
    @Async
    public Organisation getById(Long id){
        return iOrganisationRepository.findById(id).orElse(null);
    }
    public void create (Organisation organisation) {
        iOrganisationRepository.save(organisation);
    }
    public void delete(Long id) {
        iOrganisationRepository.deleteById(id);
    }
    public void update(Organisation organisation) {
        Organisation organisation1 = getById(organisation.getId());
        organisation1.setName(organisation.getName());
        organisation1.setAmountOfPeople(organisation.getAmountOfPeople());
        organisation1.setOrgBill(organisation.getOrgBill());
        iOrganisationRepository.save(organisation1);
    }
}

