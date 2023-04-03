package by.asalalaiko.apiuser.service;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;

import java.util.List;

public interface ProductService {

    boolean createProduct(Product product, User user) ;

    List<Product> findAll();

    public void saveProduct(Product product);
}
