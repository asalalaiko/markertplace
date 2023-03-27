package by.asalalaiko.apiuser.controller;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.service.ShoppingService;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/buy")
    public ResponseEntity<?> buyProduct(@RequestBody Product product, Authentication authentication) {
        String nameUser = authentication.getName();
        User user = userService.getUserByName(nameUser);
        final boolean create = shoppingService.buyProduct(product, user);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
