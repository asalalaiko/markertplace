package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.Organization;

public interface OrganizationService {

    boolean activateOrganization(Organization organization) ;

    public void saveOrganization(Organization Organization);
}
