package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.Product;
import by.asalalaiko.apiuser.dto.Shopping;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //get User by Name
    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Set<Product> getProductList(User user) {
        List<Shopping> shoppingList = user.getShoppingList();
        return shoppingList.stream().map(product -> product.getProduct()).collect(Collectors.toSet());

    }
    //add new User
    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(BigDecimal.ZERO);
        user.setDeleted(false);
        user.setLocked(false); // new User don't blocked

        saveUser(user);
        return true;
    }
    //Save user
    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }
}
