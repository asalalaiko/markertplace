package by.asalalaiko.apiadmin.controller;

import by.asalalaiko.apiadmin.dto.Organization;
import by.asalalaiko.apiadmin.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = "/org/{id}/activate")
    public ResponseEntity<?> activateOrg(@PathVariable(name = "id") int id) {
        Organization organization = organizationService.getOrganization(id);
        final boolean activate = organizationService.activateOrganization(organization);
        return activate
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/org/{id}/deactivate")
    public ResponseEntity<?> deactivateOrg(@PathVariable(name = "id") int id) {
        Organization organization = organizationService.getOrganization(id);
        final boolean deactivate = organizationService.deactivateOrganization(organization);
        return deactivate
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/org/{id}")
    public ResponseEntity<?> deleteOrg(@PathVariable(name = "id") int id) {
        Organization organization = organizationService.getOrganization(id);
        final boolean deleted = organizationService.deleteOrganization(organization);
        return deleted
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);}
}
