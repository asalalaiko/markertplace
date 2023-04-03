package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.OrganizationRepository;
import by.asalalaiko.apiuser.repository.ProductRepository;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.ProductService;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean createProduct(Product product, User user) {
        Organization orgDB = organizationRepository.findByName(product.getOrganization().getName());

        if (orgDB == null || !user.getOrganizationList().contains(orgDB)) {
            return false;
        }
        product.setLocked(true);
        product.setDeleted(false);
        saveProduct(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
