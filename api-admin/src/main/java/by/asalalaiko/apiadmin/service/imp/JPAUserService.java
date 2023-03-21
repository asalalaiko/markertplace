package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.User;
import by.asalalaiko.apiadmin.repository.UserRepository;
import by.asalalaiko.apiadmin.service.UserService;
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
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User getUser(Integer id) {
        Optional<User> userResponse =  userRepository.findById(id);
        User user = userResponse.get();
        return user;
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(BigDecimal.ZERO);
        user.setLocked(false); // new User don't blocked

        saveUser(user);
        return true;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public boolean deleteUser(Integer id) {
        Optional<User> userResponse =  userRepository.findById(id);
        User user = userResponse.get();

        if (user != null) {
            user.setLocked(true);
            saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
