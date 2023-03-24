package by.asalalaiko.apiuser.service;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.Shopping;
import by.asalalaiko.apiuser.dto.User;

import java.util.List;

public interface ShoppingService {

    boolean addProductToShopping(Product product, User user) ;

    List<Shopping> findByUser();
}
