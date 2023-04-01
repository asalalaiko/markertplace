package by.asalalaiko.apiuser.service;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;

public interface ProductService {

    boolean createProduct(Product product, User user) ;

    public void saveProduct(Product product);
}
