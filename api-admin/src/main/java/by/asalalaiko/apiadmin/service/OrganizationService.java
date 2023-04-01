package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.Organization;

public interface OrganizationService {

    Organization getOrganization (Integer id);

    boolean activateOrganization(Organization organization) ;

    public void saveOrganization(Organization Organization);
}
