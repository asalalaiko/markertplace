package by.asalalaiko.apiuser.controller;

import by.asalalaiko.apiuser.dto.Organization;
import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.service.ProductService;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        final List<Product> products = productService.findAll();

        return products != null &&  ! products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<?> buyProduct(@RequestBody Product product, Authentication authentication) {
        String nameUser = authentication.getName();
        User user = userService.getUserByName(nameUser);
        final boolean create = productService.createProduct(product, user);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
