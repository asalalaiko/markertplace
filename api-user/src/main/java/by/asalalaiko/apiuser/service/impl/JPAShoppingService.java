package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.Shopping;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.ProductRepository;
import by.asalalaiko.apiuser.repository.ShoppingRepository;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JPAShoppingService implements ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional
    public boolean buyProduct(Product product, User user) {
        if (product.getId() != null || user.getId() != null) {
            return false;
        }

        Organization organization = product.getOrganization();
        User seller = organization.getUser();

        Shopping shopping = new Shopping();
        shopping.setProduct(product);
        shopping.setUser(user);
        shoppingRepository.save(shopping);

        seller.setBalance(seller.getBalance().add(product.getCost()));
        userRepository.save(seller);

        product.setQuantity(product.getQuantity()-1);
        productRepository.save(product);

        return true;
    }

    @Override
    public List<Shopping> findByUser() {
        return null;
    }
}
