package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.repository.OrganizationRepository;
import by.asalalaiko.apiuser.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAOrganizationService implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public boolean createOrganization(Organization organization) {
        Organization orgDB = organizationRepository.findByName(organization.getName());

        if (orgDB != null) {
            return false;
        }
        organization.setLocked(true);
        saveOrganization(organization);
        return true;
    }

    @Override
    public void saveOrganization(Organization Organization) {

    }
}
