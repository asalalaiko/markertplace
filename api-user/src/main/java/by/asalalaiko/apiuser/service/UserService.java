package by.asalalaiko.apiuser.service;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.User;

import java.util.List;
import java.util.Set;


public interface UserService {

    User getUserByName(String name);
    Set<Product> getProductList(User user);
    boolean addUser(User user) ;

    public void saveUser(User user);

}
