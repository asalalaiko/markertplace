package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    //get User by Name
    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
