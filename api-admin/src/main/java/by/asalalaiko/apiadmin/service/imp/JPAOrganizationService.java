package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.Organization;
import by.asalalaiko.apiadmin.repository.OrganizationRepository;
import by.asalalaiko.apiadmin.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAOrganizationService implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public boolean activateOrganization(Organization organization) {
        Optional<Organization> orgDB = organizationRepository.findById(organization.getId());

        if (orgDB != null) {
            return false;
        }
        organization.setLocked(false);
        saveOrganization(organization);
        return true;
    }

    @Override
    public void saveOrganization(Organization organization) {
        organizationRepository.save(organization);
    }
}
