package by.asalalaiko.apiuser.controller;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "/org")
    public ResponseEntity<?> buyProduct(@RequestBody Organization organization) {
        final boolean create = organizationService.createOrganization(organization);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
