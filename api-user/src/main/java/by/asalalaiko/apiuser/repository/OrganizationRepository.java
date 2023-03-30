package by.asalalaiko.apiuser.repository;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
        Organization findByName(String name);


        }